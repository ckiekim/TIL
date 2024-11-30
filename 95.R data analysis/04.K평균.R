# 실습과제 4 (k평균 군집분석)

##### 1. "snsdata1.csv" 데이터로 teens 데이터프레임 생성
teens <- read.csv('data/snsdata1.csv')
head(teens)
dim(teens)

# 결측값 확인 - 0
sum(is.na(teens))

##### 2. teens의 13 ~ 37열의 자료를 이용하여 interests 데이터프레임 생성
#####    interests 생성후, scale을 적용하여 interests_z 생성
interests <- teens[, 13:37]
head(interests)

# interests 데이터프레임의 Z-score 표준화
interests_z <- as.data.frame(scale(interests))
head(interests_z)

##### 3. kmeans를 이용하여 teen_clusters 생성
set.seed(5432)

# k-means 클러스터링 수행 (4개의 군집 생성)
kmeans_result <- kmeans(interests_z, centers = 4, nstart = 25, iter.max = 100)

# 군집 결과를 interests_z에 추가
interests_z$cluster <- as.factor(kmeans_result$cluster)
head(interests_z)

##### 4. 본래 데이터프레임에 군집 ID(cluster ID)를 적용하여 clusters 생성
#####    생성후 101행부터 105행까지 "cluster","gender", "friends", "drunk", "drugs" 데이터 추출
clusters <- cbind(cluster = interests_z$cluster, teens)

# 101행부터 105행까지 추출
tail(head(clusters, 105), 5)

# 필요한 컬럼만 101행부터 105행까지 추출
library(dplyr)
subset_clusters <- clusters %>%
    select(cluster, gender, friends, drunk, drugs)
tail(head(subset_clusters, 105), 5)
