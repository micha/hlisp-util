(ns hlisp.util
  (:use
    [cljs.reader    :only [read-string]])
  (:require
    [clojure.string   :as string]))

(defn pluralize
  [word count]
  (str word (when (not= 1 count) "s")))

(defn capitalize
  [s]
  (when (string? s)
    (string/capitalize s)))

(defn str-partition
  [re s]
  (->> s
    (partition-by #(when (re-matches re %) true))
    (mapv (partial apply str))))

(defn capitalize-name
  [s]
  (->> s
    (str-partition #"[a-zA-Z]")
    (map capitalize)
    (apply str)))

(defn format-date
  [date-str]
  (let [[y m d] (mapv js/Number (string/split date-str #"-")) 
        months  ["January" "February" "March" "April" "May" "June" "July"
                 "August" "September" "October" "November" "December"]
        i       (dec m)]
    (if (< i 0)
      "<< Sorry, there was an error computing the date. >>"
      (str (nth months (dec m)) " " d ", " y))))

(defn localStorage-set!
  [k v]
  (.setItem js/localStorage k (pr-str v)))

(defn localStorage-get
  [k]
  (let [v-str (.getItem js/localStorage k)]
    (when-not (string/blank? v-str)
      (read-string v-str))))

