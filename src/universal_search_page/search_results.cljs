(ns universal-search-page.search-results
  (:require [reagent.core :as reagent]
            [material-ui :as mui]))

(defn search-result-card [{:keys [title subheader image description]}]
  [:> mui/Card {:class-name "search-result"}
   [:> mui/CardHeader {:title title :subheader subheader}]
   [:> mui/CardMedia {:image      image
                      :title      title
                      :class-name "media"}]
   [:> mui/CardContent
    [:> mui/Typography description]]
   [:> mui/CardActions]])

(defn search-results-cards [{:keys [list]}]
  [:div.search-results-cards
   (map #(vector search-result-card (conj {:key %} %)) list)])

(defn search-result-table-row [{:keys [title description]}]
  [:> mui/TableRow
   [:> mui/TableCell {} title]
   [:> mui/TableCell {} description]])

(defn search-results-table [{:keys [list]}]
  [:div.search-results-table
   [:> mui/Paper
    [:> mui/Table
     [:> mui/TableHead
      [:> mui/TableRow
       [:> mui/TableCell "Title"]
       [:> mui/TableCell {:align "right"} "Description"]]]
     [:> mui/TableBody
      (map #(vector search-result-table-row (conj {:key %} %)) list)]]]])

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