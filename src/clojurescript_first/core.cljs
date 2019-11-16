(ns clojurescript-first.core
  (:require [reagent.core :as reagent :refer [atom, reactify-component]]
            [material-ui :as mui]
            [material-ui-icons :as icons]
            [goog.object :as gobj]
            ["@material-ui/core/styles" :refer [createMuiTheme withStyles]]
            ["material-ui/colors" :as mui-colors]))

(enable-console-print!)

(defonce app-state (atom {:text "Search"}))

(defn hello-world []
  [:div.app
   [:div.search-bar
    [:> mui/Input {:color "primary" :full-width true}]
    [:> mui/Fab {:color "secondary"}
     [:> icons/Send]]]])

(reagent/render-component [hello-world] (. js/document (getElementById "app")))