(ns universal-search-page.core
  (:require [reagent.core :as reagent :refer [atom, reactify-component]]
            [material-ui :as mui]
            [material-ui-icons :as icons]
            [goog.object :as gobj]
            ["@material-ui/core/styles" :refer [createMuiTheme withStyles]]
            ["material-ui/colors" :as mui-colors]
            [universal-search-page.pokemons :as pokemons]))

(enable-console-print!)

(defonce app-state (atom {:text "Search"}))

(defn search-bar []
  [:div.search-bar
   [:> mui/Input {:color "primary" :full-width true}]
   [:> mui/Fab {:color "secondary"}
    [:> icons/Search]]])

(defn search-result [props]
  (let [pokemon (:pokemon props)]
    [:> mui/Card {:class-name "search-result"}
     [:> mui/CardHeader {:title (:name pokemon) :subheader (:types pokemon)}]
     [:> mui/CardMedia {:image      (:image pokemon)
                        :title      (:name pokemon)
                        :class-name "media"}]
     [:> mui/CardContent
      [:> mui/Typography (:description pokemon)]]
     [:> mui/CardActions]
     ]))

(defn search-results []
  [:div.search-results
   [search-result {:pokemon pokemons/bulbasaur}]
   [search-result {:pokemon pokemons/charmander}]
   [search-result {:pokemon pokemons/squirtle}]
   ])

(defn universal-search-page []
  [:div.app
   [search-bar]
   [search-results]
   ])

(reagent/render-component [universal-search-page] (. js/document (getElementById "app")))