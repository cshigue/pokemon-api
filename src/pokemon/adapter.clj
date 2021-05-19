(ns pokemon.adapter)

(defn wire [pokemon]
  #:pokemon {:name (get-in pokemon [:species :name])
             :image (get-in pokemon [:species :url])
             :weight (:weight pokemon)
             :height (:height pokemon)})
