{:title "Blog"
 :show-blog-nav true}

[:div {:class "container"}
 (for [f (take 5 (reverse (io/list-files :posts)))
       :let [url (post-url f)
             [metadata content] (io/read-doc f)]]
   [:div
    [:div {:class "entry-title"}
     [:h2 {:style "float:left"}
      [:a {:href url} (:title metadata)]]
     [:span {:style "float:right"
             :class "entry-date"} (format-date (:date metadata) "dd.MM.YYYY")]
     [:div {:class "clear"}]]

    [:div {:class "entry-content"}
     (if-let [synopsis (:synopsis metadata)]
       (list synopsis
             [:p {:class "readmore"}
              [:a {:href url} "Read more ->>"]])
       content)]])
 [:p "For more posts check out the " [:a {:href "/blog/archives.html"} "Archives"] " Web page >>"]]
