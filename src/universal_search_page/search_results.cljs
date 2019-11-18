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

(defn search-results-table [{:keys [list]}]
  [:div.search-results-table
   [:> mui/Table
    [:> mui/TableHead
     [:> mui/TableRow
      [:> mui/TableCell "Dessert (100g serving)"]
      [:> mui/TableCell {:align "right"} "Calories"]
      [:> mui/TableCell {:align "right"} "Fat (g)"]
      [:> mui/TableCell {:align "right"} "Carbs (g)"]
      [:> mui/TableCell {:align "right"} "Protein (g)"]]]
    ]])

;  [:Paper{:className "{classes.root}"}
;[mui/Table {:className "{classes.table}" :aria-label "simple table"}
; [mui/TableHead
;  [mui/TableRow
;   [mui/TableCell "Dessert (100g serving)"]
;   [mui/TableCell {:align "right"} "Calories"]
;   [mui/TableCell {:align "right"} "Fat&nbsp;(g)"]
;   [mui/TableCell {:align "right"} "Carbs&nbsp;(g)"]
;   [mui/TableCell {:align "right"} "Protein&nbsp;(g)"]]]
; [mui/TableBody "{rows.map(row => ("
;  [mui/TableRow {:key "{row.name}"}
;   [mui/TableCell {:component "th" :scope "row"} "{row.name}"]
;   [mui/TableCell {:align "right"} "{row.calories}"]
;   [mui/TableCell {:align "right"} "{row.fat}"]
;   [mui/TableCell {:align "right"} "{row.carbs}"]
;   [mui/TableCell {:align "right"} "{row.protein}"]] "))}"]]

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