;; build.boot
(set-env!
 :source-paths #{"src/"}
 :dependencies '[[org.clojure/clojure "1.9.0"]
                 [hiccup "1.0.5" :scope "test"]
                 [pandeiro/boot-http "0.8.3" :scope "test"]])

(task-options!
  pom {:project 'clojure-todo-mvp
       :description "Minimal todo list implementation"
       :license {"MIT" "https://mit-license.org"}
       :developers {"Ben Lovy" "ben@deciduously.com"}})

(require '[pandeiro.boot-http :refer [serve]])

(deftask dev
  "Run live development server"
  []
  (comp
    (serve :handler 'clojure-todo-mvp.core/handler :reload true :port 3000)
    (wait)))

