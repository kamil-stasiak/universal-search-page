(ns universal-search-page.pokemons)

(def bulbasaur
  {:name        "Bulbasaur"
   :types       "Grass/Poison"
   :image       "https://cdn.bulbagarden.net/upload/2/21/001Bulbasaur.png"
   :description "Bulbasaur is a dual-type Grass/Poison Pokémon introduced in Generation I.\n\nIt evolves into Ivysaur starting at level 16, which evolves into Venusaur starting at level 32.\n\nAlong with Charmander and Squirtle, Bulbasaur is one of three starter Pokémon of Kanto available at the beginning of Pokémon Red, Green, Blue, FireRed, and LeafGreen."})

(def charmander
  {:name        "Charmander"
   :types       "Fire"
   :image       "https://cdn.bulbagarden.net/upload/7/73/004Charmander.png"
   :description "Charmander is a Fire-type Pokémon introduced in Generation I.\n\nIt evolves into Charmeleon starting at level 16, which evolves into Charizard starting at level 36.\n\nAlong with Bulbasaur and Squirtle, Charmander is one of three starter Pokémon of Kanto available at the beginning of Pokémon Red, Green, Blue, FireRed, and LeafGreen."})

(def squirtle
  {:name        "Squirtle"
   :types       "Water"
   :image       "https://cdn.bulbagarden.net/upload/3/39/007Squirtle.png"
   :description "Squirtle is a Water-type Pokémon introduced in Generation I.\n\nIt evolves into Wartortle starting at level 16, which evolves into Blastoise starting at level 36.\n\nAlong with Bulbasaur and Charmander, Squirtle is one of three starter Pokémon of Kanto available at the beginning of Pokémon Red, Green, Blue, FireRed, and LeafGreen."})

(def pokemons-list [bulbasaur charmander squirtle])

(defn pokemon-to-card [{:keys [name types image description]}]
  {:title name
   :subheader types
   :image image
   :description description})