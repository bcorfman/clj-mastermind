(defproject mastermind "0.1.0"
  :description "A Clojure solution to the kata at https://codingdojo.org/kata/Mastermind/"
  :url "https://github.com/bcorfman/clj-mastermind"
  :license {:name "MIT License"
            :url "https://choosealicense.com/licenses/mit/"
            :year 2022
            :key "mit"}
  :dependencies [[org.clojure/clojure "1.10.3"]]
  :main ^:skip-aot mastermind.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
