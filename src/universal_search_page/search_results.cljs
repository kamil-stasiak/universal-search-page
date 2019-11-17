(ns universal-search-page.search-results
  (:require [reagent.core :as reagent :refer [atom, reactify-component]]
            [material-ui :as mui]
            [material-ui-icons :as icons]
            [goog.object :as gobj]
            ["@material-ui/core/styles" :refer [createMuiTheme withStyles]]
            ["material-ui/colors" :as mui-colors]
            [universal-search-page.pokemons :refer [pokemons-list pokemon-to-card]]
            [universal-search-page.search-bar :refer [search-bar]]))

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
   (for [element list]
     [search-result (conj {:key element} element)])])