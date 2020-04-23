(ns exercise2.core
  (:gen-class))

;Original expression (1 + 3 * 4 - 5)

(defmacro infix [expression]
  (def map-exp (into [] expression))
  ((get map-exp 5) ((get map-exp 1) (get map-exp 0)((get map-exp 3) (get map-exp 2) (get map-exp 4)))(get map-exp 6)))


(defn -main
  [& args]
  (println (infix (1 + 3 * 4 - 5)))) 
  ;(- (+ 1 (* 3 4)) 5))
