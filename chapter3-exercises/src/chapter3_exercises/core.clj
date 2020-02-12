(ns chapter3-exercises.core
  (:gen-class))

(defn exercise-1 
  "Utiliza as funcoes str, vector, list, hash-set e hash-map"
  []
    (println (str "STR: " "Usando " "funcao " "str " "em " "clojure "))

    (println "VECTOR: Criando vetor em clojure 1 " (vector 1 2 3 4 5 6 7 8 9))
    (println "VECTOR: Criando vetor em clojure 2 " [1 2 3 4 5 6 7 8 9])

    (println "LIST: Criando list em clojure 1 " (list 1 2 3 4 5 6 7 8 9))
    (println "LIST: Criando list em clojure 2 " [1 2 3 4 5 6 7 8 9])

    (println "HASH-SET: " #{ :a :b :c :d :e :f :g })
    (println "HASH-MAP: " { :key1 1, :key2 2, :key3 3, :key4 4 })
  )

(defn exercise-2
  "Recebe um numero e acrescenta 100"
  [number]
  (+ number 100))

 (defn dec-maker
  "Exercicio retornando funcoes"
  [dec-by]
  #(- % dec-by)) 

(def dec25 (dec-maker 25))

(defn mapset 
  "Exercicio 4 - Converte um vector numa hashset apos uma operacao"
  [f coll]
  (into #{} (map f coll))
)

(def asym-alien-body-parts [{ :name "head" :size 3 }
                            { :name "first-eye" :size 1 }
                            { :name "first-ear" :size 1 }
                            { :name "mouth" :size 1 }
                            { :name "nose" :size 1 }
                            { :name "neck" :size 1 }
                            { :name "first-shoulder" :size 1 }
                            { :name "first-upper-arm" :size 1 }
                            { :name "chest" :size 1 }
                            { :name "back" :size 1 }
                            { :name "first-forearm" :size 1 }
                            { :name "abdomen" :size 1 }
                            { :name "first-kidney" :size 1 }
                            { :name "first-thigh" :size 1 }
                            { :name "first-lower-leg" :size 1 }
                            { :name "first-achilles" :size 1 }
                            { :name "first-foot" :size 1 }
                           ]
)

(def positions [ "first", "second", "third", "fourth", "fifth"])

(defn matching-part 
  [part position]
  { :name (clojure.string/replace (:name part) "first" (nth positions position))
    :size (:size part)
  }
)

(defn symmetrize-body-parts
  "Exercicio 5 - baseado no summerize hobbit body part"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]            
        (recur remaining                         
          (into final-body-parts
            ;; Nao sei como fazer melhor kkk
            (set [part (matching-part part 1) (matching-part part 2) (matching-part part 3) (matching-part part 4)])                  
          )          
        )         
      )
    )
  )
) 

(defn -main
  [& args]
  ;; (exercise-1)
  ;; (println (exercise-2 50))
  ;; (println (dec25 26))
  ;; (println (mapset inc [1 1 2 2]))
  (println (symmetrize-body-parts asym-alien-body-parts))
)
