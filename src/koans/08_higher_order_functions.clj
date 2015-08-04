(ns koans.08-higher-order-functions
  (:require [koan-engine.core :refer :all]))

(defn byFour [num]
  (* num 4))

(defn byTen [num]
  (* num 10))

(defn byMag [ num mag ]
  (* num mag))

(defn sortStrings [string1 string2]
  (if (< (count string1) (count string2))
    string2
    string1
    ))

(defn square [x]
  (* x x))

(defn isFalse [keyword]
  (false? keyword))

(defn notRobustAtAll [x]
  (cond (= x 10) x
        (= x 20) x
        (= x 30) x))

(defn oneTwoThree [num]
  (cond (= num 1) num
        (= num 2) num
        (= num 3) num))
(defn forcedTrue [keyword]
  true)
(meditations
  "The map function relates a sequence to another"
  (= [4 8 12]
     (map byFour
          [1 2 3]))

  "You may create that mapping"
  (= [1 4 9 16 25]
     (map square
          [1 2 3 4 5]))

  "Or use the names of existing functions"
  (= [false false true false false]
     (map nil?
          [:a :b nil :c :d]))

  "A filter can be strong"
  (= '()
     (filter isFalse
             '(:anything :goes :here)))

  "Or very weak"
  (= '(:anything :goes :here)
     (filter forcedTrue
             '(:anything :goes :here)))

  "Or somewhere in between"
  (= [10 20 30]
     (filter notRobustAtAll
             [10 20 30 40 50 60 70 80]))

  "Maps and filters may be combined"
  (= [10 20 30]
     (map byTen
          (filter oneTwoThree
                  [1 2 3 4 5 6 7 8])))

  "Reducing can increase the result"
  (= 24 (reduce byMag
                [1 2 3 4]))

  "You can start somewhere else"
  (= 2400
     (reduce byMag
             100 [1 2 3 4]))

  "Numbers are not the only things one can reduce"
  (= "longest"
     (reduce sortStrings
             ["which" "word" "is" "longest"])))
