# 실습과제 2 (신경망 분석)

##### 1. 제공된 과제 데이터 로드 후, 데이터에 대해서 전체적으로 탐색하기
library(dplyr)
df = read.csv('data/INTC.csv')

# 데이터 구조 확인
str(df)
dim(df)

# 요약 통계
summary(df)

# 결측값 확인
sum(is.na(df))           # 전체 결측값 개수

# 처음 몇 개의 행 확인
head(df)
# 마지막 몇 개의 행 확인
tail(df)

##### 2. 전체 데이터 프레임에 정규화 적용
# caret 패키지 설치 및 로드
library(caret)

# Min-Max 정규화
preproc <- preProcess(df, method = c("range"))
df_normalized <- predict(preproc, df)

# 결과 확인
head(df_normalized)

##### 3. train set과 test set 만들기
set.seed(2024)
n <- nrow(df_normalized)
train_indices <- sample(seq_len(n), size = round(0.75 * n)) # 75%는 train
train <- df_normalized[train_indices, ]                                # train 데이터
test <- df_normalized[-train_indices, ]                                # test 데이터

dim(train)
dim(test)

##### 4. TomorrowOpen을 예측하는 neuralnet 모델 훈련
# neuralnet 패키지 로드
library(neuralnet)

# 시드 고정
set.seed(1313)

# formula로 예측할 변수와 입력 변수를 지정
formula <- TomorrowOpen ~ Open + High + Low + Close + Adj.Close + Volume

### 1. 은닉층 1개
# a. 신경망 모델 생성
nn_model <- neuralnet(
    formula,
    data = train,
    hidden = c(1),         # 은닉층 1개
    linear.output = TRUE,  # 연속형 변수 예측
    stepmax = 1e6          # 최대 반복 수 설정 (필요 시 조정)
)

# b. 모델 결과 확인
print(nn_model)
plot(nn_model)  # 신경망 시각화

# c. 예측 수행
nn_predictions <- compute(nn_model, test[, c("Open", "High", "Low", "Close", "Adj.Close", "Volume")])

# d. 결과 확인
test$Predicted_TomorrowOpen <- nn_predictions$net.result
head(test[, c("TomorrowOpen", "Predicted_TomorrowOpen")])

# e. 평가 - MSE: 0.0003132175, R-squared: 0.9947007
mse <- mean((test$TomorrowOpen - test$Predicted_TomorrowOpen)^2)
cat("Mean Squared Error (MSE):", mse, "\n")

r2 <- 1 - sum((test$TomorrowOpen - test$Predicted_TomorrowOpen)^2) / 
    sum((test$TomorrowOpen - mean(test$TomorrowOpen))^2)
cat("R-squared (R²):", r2, "\n")

### 2. 은닉층 5개
# a. 신경망 모델 생성
nn_model <- neuralnet(
    formula,
    data = train,
    hidden = c(1),         # 은닉층 5개
    linear.output = TRUE,  # 연속형 변수 예측
    stepmax = 1e6          # 최대 반복 수 설정 (필요 시 조정)
)

# b. 모델 결과 확인
print(nn_model)
plot(nn_model)  # 신경망 시각화

# c. 예측 수행
nn_predictions <- compute(nn_model, test[, c("Open", "High", "Low", "Close", "Adj.Close", "Volume")])

# d. 결과 확인
test$Predicted_TomorrowOpen <- nn_predictions$net.result
head(test[, c("TomorrowOpen", "Predicted_TomorrowOpen")])

# e. 평가 - MSE: 0.0003092077, R-squared: 0.9947686
mse <- mean((test$TomorrowOpen - test$Predicted_TomorrowOpen)^2)
cat("Mean Squared Error (MSE):", mse, "\n")

r2 <- 1 - sum((test$TomorrowOpen - test$Predicted_TomorrowOpen)^2) / 
    sum((test$TomorrowOpen - mean(test$TomorrowOpen))^2)
cat("R-squared (R²):", r2, "\n")

# 은닉층이 1개인 경우 MSE: 0.0003132175, R-squared: 0.9947007
# 은닉층이 5개인 경우 MSE: 0.0003092077, R-squared: 0.9947686
# 은닉층이 5개인 경우가 1개인 경우에 비해 성능이 약간 좋음
