(ns universal-search-page.search-bar
  (:require [reagent.core :as reagent :refer [atom, reactify-component]]
            [material-ui :as mui]
            [material-ui-icons :as icons]))

(defn search-bar []
  [:div.search-bar
   [:> mui/Input {:color "primary" :full-width true}]
   [:> mui/Fab {:color "secondary"}
    [:> icons/Search]]])