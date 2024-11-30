# 실습과제 1 (의사결정나무)
library(dplyr)

##### 1. 제공된 과제 데이터 로드 후, 데이터에 대해서 전체적으로 탐색하기
df <- read.csv(file = "data/house_price_prediction.csv")

# 데이터 구조 확인
str(df)
dim(df)

# 컬럼 이름 확인
colnames(df)

# 요약 통계
summary(df)

# 결측값 확인
sum(is.na(df))           # 전체 결측값 개수
colSums(is.na(df))       # 각 열의 결측값 개수

# 처음 몇 개의 행 확인
head(df)
# 마지막 몇 개의 행 확인
tail(df)

##### 2. price가 500000 이하면 "L"로, 500000 초과면 "H"로 factor화 시키기
df <- df %>%
    mutate(price_cat = factor(ifelse(price <= 500000, 'L', 'H'))) %>%
    select(-price)
head(df)            # price 열은 없애고 대신 price_cat 열을 생성함

##### 3. 시드 값을 정하고, 무작위 샘플 추출 후 train과 test set 생성
# seed 값: 2024
# train과 test set의 비율 = 3 : 1
set.seed(2024)
n <- nrow(df)
train_indices <- sample(seq_len(n), size = round(0.75 * n)) # 75%는 train
train <- df[train_indices, ]                                # train 데이터
test <- df[-train_indices, ]                                # test 데이터

dim(train)
dim(test)

##### 4. C50 라이브러리의 분류 트리 모델 생성
library(C50)

# 분류 트리 모델 생성
c50_model <- C5.0(price_cat ~ ., data = train)

# 모델 요약 출력
summary(c50_model)

# 트리 시각화 (RStudio에서만 가능)
plot(c50_model)

##### 5. 4.의 모델을 통한 예측 및 교차표 생성

# test 데이터에 대해 예측
predictions <- predict(c50_model, newdata = test)

# 예측 결과와 실제값 비교
confusion_matrix <- table(test$price_cat, predictions)
print(confusion_matrix)

# 정확도 계산
accuracy <- sum(diag(confusion_matrix)) / sum(confusion_matrix)
cat("Accuracy:", accuracy, "\n")

##### 6. boost를 통한 성능 향상 관찰 및 설명
for (count in 1:20) {
    boosted_model <- C5.0(price_cat ~ ., data = train, trials = count)
    predictions <- predict(boosted_model, newdata = test)
    confusion_matrix <- table(test$price_cat, predictions)
    accuracy <- sum(diag(confusion_matrix)) / sum(confusion_matrix)
    cat("Trials의 갯수:", count, "--> Accuracy with Boosting:", accuracy, "\n")
}
# Trials 갯수를 점차 늘려가면서 정확도가 어떻게 변화하는지 파악
# Trials 값이 30 정도에서 최고 정확도 0.8005272 를 구했고
# 이후 값을 늘려도 정확도가 더 좋아지지 않았음

