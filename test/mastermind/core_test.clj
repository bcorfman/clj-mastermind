(ns mastermind.core-test
  (:require [clojure.test :refer :all]
            [mastermind.core :refer :all]))

(deftest evaluate-different-secret-and-guess-length
  (testing "evaluate secret and guess different lengths"
    (is (thrown? Exception (evaluate [1 2 3] [4 5])))))

;(deftest evaluate-correct-secret-and-guess
;  (testing "evaluate secret and guess parameters are correct"
;    (is (= (evaluate [1 2 3] [4 5 6]) nil))))

(deftest first-kata-test-find-1-well-placed-color-out-of-4
  (testing "first sample test from kata"
    (let [secret ["blue" "red" "green" "pink"]
          guess ["yellow" "red" "blue" "purple"]]
      (is (= 1 (find-well-placed-colors secret guess))))))

(deftest second-kata-test-find-0-well-placed-colors-out-of-1
  (testing "second sample test from kata"
    (let [secret ["blue"]
          guess ["red"]]
      (is (= 0 (find-well-placed-colors secret guess))))))

(deftest third-kata-test-find-1-well-placed-colors-out-of-1
  (testing "third sample test from kata"
    (let [secret ["blue"]
          guess ["blue"]]
      (is (= 1 (find-well-placed-colors secret guess))))))

(deftest fourth-kata-test-find-0-well-placed-colors-out-of-2
  (testing "fourth sample test from kata"
    (let [secret ["red" "yellow"]
          guess ["blue" "red"]]
      (is (= 0 (find-well-placed-colors secret guess))))))

(deftest first-kata-test-find-1-misplaced-colors-out-of-4
  (testing "first sample test from kata"
    (let [secret ["blue" "red" "green" "pink"]
          guess ["yellow" "red" "blue" "purple"]]
      (is (= 1 (find-misplaced-colors secret guess))))))

(deftest second-kata-test-find-0-misplaced-colors-out-of-1
  (testing "second sample test from kata"
    (let [secret ["blue"]
          guess ["red"]]
      (is (= 0 (find-misplaced-colors secret guess))))))

(deftest third-kata-test-find-0-misplaced-colors-out-of-1
  (testing "third sample test from kata"
    (let [secret ["blue"]
          guess ["blue"]]
      (is (= 0 (find-misplaced-colors secret guess))))))

(deftest fourth-kata-test-find-1-misplaced-colors-out-of-2
  (testing "fourth sample test from kata"
    (let [secret ["red" "yellow"]
          guess ["blue" "red"]]
      (is (= 1 (find-misplaced-colors secret guess))))))

(deftest first-kata-test-evaluation
  (testing "first sample test from kata"
    (let [secret ["blue" "red" "green" "pink"]
          guess ["yellow" "red" "blue" "purple"]]
      (is (= [1 1] (evaluate secret guess))))))

(deftest second-kata-test-evaluation
  (testing "second sample test from kata"
    (let [secret ["blue"]
          guess ["red"]]
      (is (= [0 0] (evaluate secret guess))))))

(deftest third-kata-test-evaluation
  (testing "third sample test from kata"
    (let [secret ["blue"]
          guess ["blue"]]
      (is (= [1 0] (evaluate secret guess))))))

(deftest fourth-kata-test-evaluation
  (testing "fourth sample test from kata"
    (let [secret ["red" "yellow"]
          guess ["blue" "red"]]
      (is (= [0 1] (evaluate secret guess))))))
