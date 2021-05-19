(ns pokemon.controller
  (:require [clj-http.client :as client]
            [pokemon.adapter :as adapter]))

(def api "https://pokeapi.co/api/v2/pokemon/")
(def limit 10)

(defn by-name [name]
  (-> (str api name)
      (client/get {:as :json})
      :body
      adapter/wire))

(defn by-name-original [name]
  (-> (str api name)
      (client/get {:as :json})
      :body
      (select-keys [:species :height])
      vals))

(defn all-by-offset [offset]
  (println (str "===> " offset))
  (let [query-params {:limit limit
                      :offset offset}] 
    (-> api
        (client/get {:as :json :query-params query-params})
        :body
        :results)))
 