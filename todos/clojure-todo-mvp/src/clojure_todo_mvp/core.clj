(ns clojure-todo-mvp.core
  (:require [hiccup.form :refer [form-to]]
            [hiccup.page :refer [html5]]))

  (def index-page
    (html5
     [:head
      [:link
       {:rel "stylesheet" :href "/static/todo.css"}]
      [:title "Todo MVP"]
      [:meta {:charset "utf-8"}]]
     [:body
      [:h1 "Todo MVP"]
      [:section.new-todo
       (form-to
        [:post ""]
        [:input#new-item
         {:type "text"
          :name "item"
          :pattern ".{3,}"
          :required true
          :aria-label "Write a new todo item"
          :title "3 characters minimum"}]
        [:input#add-new-item {:type "submit" :value "Add new item"}]
        )]
      [:section.items
       [:h2 "Todo list"]
       [:ul]]]))

(defn handler [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body index-page}) 
