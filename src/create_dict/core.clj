(ns create-dict.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(def text
  (slurp "http://www.ling.uni-potsdam.de/~kolb/de-top100K-freq.txt"))


(defn create-dict [text]
  (->> (.split text "\n")
       (map (comp vec #(.split % " ")))
       (into {})))


(defn save-dict [dict]
  (spit "/home/kima/programming/create-dict/resources/dict.edn"
        (pr-str dict)))


