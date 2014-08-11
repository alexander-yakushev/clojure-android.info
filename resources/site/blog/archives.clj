{:title "Archives"
 :show-blog-nav true}

[:div.container
 [:p]
 [:ul.posts
  (for [f (reverse (io/list-files :posts))
        :let [url (post-url f)
              [metadata content] (io/read-doc f)]]
    [:li {:style "list-style: none outside none;"}
     [:div
      [:a {:href url} (:title metadata)]
      [:span.entry-date {:style "float:right"}
       (format-date (:date metadata) "dd.MM.YYYY")]
      [:div.clear]]])]]
