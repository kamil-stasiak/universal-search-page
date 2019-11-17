(ns universal-search-page.search-results
  (:require [reagent.core :as reagent]
            [material-ui :as mui]))

(defn search-result [{:keys [title subheader image description]}]
  [:> mui/Card {:class-name "search-result"}
   [:> mui/CardHeader {:title title :subheader subheader}]
   [:> mui/CardMedia {:image      image
                      :title      title
                      :class-name "media"}]
   [:> mui/CardContent
    [:> mui/Typography description]]
   [:> mui/CardActions]])

(defn search-results [{:keys [list]}]
  [:div.search-results
   (map #(vector search-result (conj {:key %} %)) list)])

; 1
;(defn map-search [element]
;  [search-result (conj {:key element} element)])

; 2
;(defn search-results [{:keys [list]}]
;  [:div.search-results
;   (map (fn [element] [search-result (conj {:key element} element)]) list)])
;3
;(defn search-results [{:keys [list]}]
;  [:div.search-results
;   (for [element list]
;     [search-result (conj {:key element} element)])])