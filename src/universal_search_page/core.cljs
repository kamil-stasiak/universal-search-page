(ns universal-search-page.core
  (:require [reagent.core :as reagent :refer [atom, reactify-component]]
            [material-ui :as mui]
            [material-ui-icons :as icons]
            [goog.object :as gobj]
            ["@material-ui/core/styles" :refer [createMuiTheme withStyles]]
            ["material-ui/colors" :as mui-colors]))

(enable-console-print!)

(defonce app-state (atom {:text "Search"}))

(def bulbasaur
  {:name        "Bulbasaur"
   :types       "Grass/Poison"
   :image       "https://cdn.bulbagarden.net/upload/2/21/001Bulbasaur.png"
   :description "Bulbasaur is a dual-type Grass/Poison Pokémon introduced in Generation I.\n\nIt evolves into Ivysaur starting at level 16, which evolves into Venusaur starting at level 32.\n\nAlong with Charmander and Squirtle, Bulbasaur is one of three starter Pokémon of Kanto available at the beginning of Pokémon Red, Green, Blue, FireRed, and LeafGreen."})

(defn search-bar []
  [:div.search-bar
   [:> mui/Input {:color "primary" :full-width true}]
   [:> mui/Fab {:color "secondary"}
    [:> icons/Send]]])

(defn search-result [props]
  [:> mui/Card {:class-name "search-result"}
   [:> mui/CardHeader {:title (get-in props [:pokemon :name]) :subheader (get-in props [:pokemon :name])}]
   [:> mui/CardMedia {:image      (get-in props [:pokemon :image])
                      :title      (get-in props [:pokemon :name])
                      :class-name "media"}]
   [:> mui/CardContent
    [:> mui/Typography (get-in props [:pokemon :description])]]
   [:> mui/CardActions]
   ])

(defn search-results []
  [:div.search-results
   [search-result {:pokemon bulbasaur}]
   [search-result {:pokemon bulbasaur}]
   [search-result {:pokemon bulbasaur}]
   ])

(defn universal-search-page []
  [:div.app
   [search-bar]
   [search-results]
   ])

(reagent/render-component [universal-search-page] (. js/document (getElementById "app")))