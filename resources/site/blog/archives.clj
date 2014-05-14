{:title "Archives"
 :show-blog-nav true}

[:div {:class "container"}
 [:p]
 [:ul {:class "posts"}
  (for [f (reverse (io/list-files :posts))
        :let [url (post-url f)
              [metadata content] (io/read-doc f)]]
    [:li {:style "list-style: none outside none;"}
     [:div
      [:a {:href url} (:title metadata)]
      [:span {:style "float:right"
              :class "entry-date"} (format-date (:date metadata) "dd.MM.YYYY")]
      [:div {:class "clear"}]]

     ])]]
