(ns clojurescript-first.core
  (:require [reagent.core :as reagent :refer [atom]]
            [material-ui :as mui]
            [material-ui-icons :as icons]
            [goog.object :as gobj]
            ["material-ui/colors" :as mui-colors]))

(enable-console-print!)

(defonce app-state (atom {:text "Search"}))

(defn hello-world []
  [:> mui/Container {:max-width "lg"}
   [:> mui/Grid {:container true :direction "row" :justify "space-between" :align-items "flex-end"}
    [:> mui/Grid {:item true :xs 11}
     [:> mui/Input {:color "primary" :full-width true}]]
    [:> mui/Grid {:item true :xs 1}
     [:> mui/Fab {:color "secondary"} [:> icons/Send]]]]])

(reagent/render-component [hello-world] (. js/document (getElementById "app")))