(ns universal-search-page.core
  (:require [reagent.core :as reagent :refer [atom, reactify-component]]
            [material-ui :as mui]
            [material-ui-icons :as icons]
            [goog.object :as gobj]
            ["@material-ui/core/styles" :refer [createMuiTheme withStyles]]
            ["material-ui/colors" :as mui-colors]
            [universal-search-page.pokemons :refer [pokemons-list pokemon-to-card]]
            [universal-search-page.search-bar :refer [search-bar]]
            [universal-search-page.search-results :refer [search-results]]))

(enable-console-print!)

(defonce app-state (atom {:text "Search"}))

(defn universal-search-page []
  [:div.app
   [search-bar]
   [search-results {:list (map pokemon-to-card pokemons-list)}]
   ])

(reagent/render-component [universal-search-page] (. js/document (getElementById "app")))