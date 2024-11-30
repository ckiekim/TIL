# 실습과제 3 (SVM)

##### 1. 데이터 로드 후, 구조 확인 및 데이터 파악
library(caret)
df <- read.csv('data/breast-cancer-wisconsin-data.csv')
head(df)

# 데이터 구조 확인
str(df)
dim(df)

# 결측값 확인
sum(is.na(df))           # 전체 결측값 개수
colSums(is.na(df))       # 각 열의 결측값 개수

# 결측값이 있는 마지막 컬럼 X를 제거
df <- df[, !names(df) %in% "X"] 

# 데이터 분석에 필요하지 않은 첫번째 컬럼 id를 제거
df <- df[, !names(df) %in% "id"]

# diagnosis 컬럼을 제외한 나머지 열 표준화
features <- df[, !names(df) %in% "diagnosis"]   # diagnosis를 제외한 나머지 열 추출
preproc <- preProcess(features, method = c("center", "scale"))  # 표준화 (Z-score normalization)
features_standardized <- predict(preproc, features)

# 표준화된 데이터 확인
head(features_standardized)

# diagnosis를 factor로 변환하고 결합하여 최종 데이터프레임 생성
df$diagnosis <- as.factor(df$diagnosis)
df_standardized <- cbind(diagnosis = df$diagnosis, features_standardized)

# 결과 확인
head(df_standardized)

##### 2. train, test set 지정 후 SVM 모형 훈련
set.seed(2024)
n <- nrow(df_standardized)
train_indices <- sample(seq_len(n), size = round(0.75 * n)) # 75%는 train
train <- df_standardized[train_indices, ]                                # train 데이터
test <- df_standardized[-train_indices, ]                                # test 데이터

dim(train)
dim(test)

# e1071 패키지 로드
library(e1071)

# SVM 모델 생성
svm_model <- svm(diagnosis ~ ., data = train, kernel = "radial")

# 모델 요약
summary(svm_model)

##### 3. test 데이터에 대한 예측 및 평가 진행
# 테스트 데이터 예측
svm_predictions <- predict(svm_model, test)

# 혼동 행렬 계산
confusion_matrix <- table(Predicted = svm_predictions, Actual = test$diagnosis)
print(confusion_matrix)

# 정확도 계산 - 0.9788732
accuracy <- sum(diag(confusion_matrix)) / sum(confusion_matrix)
cat("Accuracy:", accuracy, "\n")
