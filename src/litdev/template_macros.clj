(ns litdev.template-macros
  (:require [hiccup.core :as h]
            [clojure.pprint :as pp]))

;"This macro takes a form like ")
; [:p "pwa"])
; "and transforms it into")
; (lit/html #js["<p>" "<p>"] "pwa"))
(defn render-html [html-edn]
  (h/html html-edn)
  `(lit-html/html
     ~(into (list (h/html html-edn)) (list 'js/Array 'new))
     [""]))

(pp/pprint
  (macroexpand
         (render-html [:p "pwa"])))