(defn start [a]
    (loop [head (first a)
           tail (rest a)
           times 1
           s [head]]

      (let [second (first tail)
            same (= head second)
            n (if (true? same) (inc times) 1)
            a (if (true? same)
                s
                (conj
                  (if (> times 1)
                    (conj s times)
                    s)
                  second))]

        (if (> (count tail) 1)
          (recur (first tail) (rest tail) n a)
          (println (reduce str
                     (if (= n 1)
                       a
                       (conj a n))))))))

(start (clojure.string/split (read-line) #""))
