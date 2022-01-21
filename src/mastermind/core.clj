(ns mastermind.core
  (:gen-class))

;;;; https://codingdojo.org/kata/Mastermind/
;;;; Kata solution by Brandon Corfman

(defn find-misplaced-colors [secret guess & [numMisplacedColors knownColors]]
  (let [numMisplacedColors (or numMisplacedColors 0)
        knownColors (or knownColors (set secret))]
    (if (empty? guess)
      numMisplacedColors
      (let [secret-color (first secret)
            guess-color (first guess)]
        (if (and (not (= guess-color secret-color)) (contains? knownColors guess-color))
          (find-misplaced-colors (rest secret) (rest guess) (inc numMisplacedColors) knownColors)
          (find-misplaced-colors (rest secret) (rest guess) numMisplacedColors knownColors))))))

(defn find-well-placed-colors [secret guess & [numWellPlacedColors]]
  (let [numWellPlacedColors (or numWellPlacedColors 0)]
    (if (empty? secret)
      numWellPlacedColors
      (let [color (first secret)]
        (if (= (first guess) color)
          (find-well-placed-colors (rest secret) (rest guess) (inc numWellPlacedColors))
          (find-well-placed-colors (rest secret) (rest guess) numWellPlacedColors))))))

(defn evaluate [secret guess]
  (when (not= (count secret) (count guess))
    (throw (new Exception "secret and guess are different lengths.")))
  [(find-well-placed-colors secret guess) (find-misplaced-colors secret guess)])

(defn -main
  "Execute Mastermind with a simple test case."
  []
  (let [secret-combination ["blue" "red" "green" "pink"]
        guess ["yellow" "red" "blue" "purple"]
        [num-well-placed num-misplaced] (evaluate secret-combination guess)]
    (println "*** Mastermind ***")
    (println "Secret combination:" secret-combination)
    (println "Guess: " guess)
    (println "Number of well placed colors: " num-well-placed)
    (println "Number of misplaced colors: " num-misplaced)))
