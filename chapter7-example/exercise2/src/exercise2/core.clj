(ns exercise2.core
  (:gen-class))

(defmacro infix 
  [[n1 op1 n2 op2 n3 op3 n4]]
  (list op1 n1 (list op3 (list op2 n2 n3) n4)))

(defn -main
  [& args]
  (println (infix (1 + 3 * 4 - 5)))) 