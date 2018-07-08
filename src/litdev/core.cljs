(ns litdev.core
    (:require [lit-html :as lit]))

(enable-console-print!)

(println "This text is printed from src/litdev/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn rendertest []
  (lit/render
    (lit/html
      #js["<p>""</p>"] (:text @app-state))
    (.querySelector js/document "#app")))

(defn on-js-reload []
  (rendertest))
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)

