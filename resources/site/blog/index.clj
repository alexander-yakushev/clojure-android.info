{:title "Blog"
 :show-blog-nav true}

[:div.container
 (for [f (take 5 (reverse (io/list-files :posts)))
       :let [url (post-url f)
             [metadata content] (io/read-doc f)]]
   [:div
    [:div.entry-title
     [:h2 {:style "float:left"}
      [:a {:href url} (:title metadata)]]
     [:span.entry-date {:style "float:right"}
      (format-date (:date metadata) "dd.MM.YYYY")]
     [:div.clear]]

    [:div.entry-content
     (if-let [synopsis (:synopsis metadata)]
       (list synopsis
             [:p.readmore
              [:a {:href url} "Read more ->>"]])
       content)]])
 [:p "For more posts check out the " [:a {:href "/blog/archives.html"} "Archives"] " Web page >>"]]
