(let [clojure [:span "Clo" [:span {:style "letter-spacing:2px;"} [:i "j"]] "ure"]

      ca-logo ["  " clojure "-Android"]
      blog-timespan (let [created (:date-created (config))
                          now (+ (.getYear (java.util.Date.)) 1900)]
                      (if (= created now)
                        (str created)
                        (str created "-" now)))]
  [:html
   {:xmlns "http://www.w3.org/1999/xhtml", :lang "en", :xml:lang "en"}
   [:head
    [:meta {:http-equiv "content-type", :content "text/html; charset=UTF-8"}]
    [:meta {:name "description", :content (:description metadata)}]
    [:meta {:name "keywords", :content (:tags metadata)}]
    [:meta {:name "author", :content (:site-author (config))}]

    [:meta {:name "viewport", :content "width=device-width, initial-scale=1.0"}]
    [:link {:rel "stylesheet", :type "text/css", :href "/css/bootstrap.min.css"}]
    [:link {:rel "stylesheet", :type "text/css", :href "/css/default.css"}]
    [:link {:rel "stylesheet", :type "text/css", :href "/css/tomorrow_night.css"}]
    [:link {:rel "icon", :href "/images/favicon.ico" :type "image/x-icon"}]
    [:link {:rel "shortcut icon",:href "/images/favicon.ico" :type "image/x-icon"}]
    [:title (if (= (:title metadata) "Home")
              (:site-title (config))
              (str (:title metadata) " - " (:site-title (config))))]]
   [:body
    [:div.container
     [:div.navbar.navbar-default {:role "navigation"}
      [:div.navbar-header
       [:button.navbar-toggle {:type "button",:data-toggle "collapse",
                               :data-target ".navbar-collapse"}
        [:span.sr-only "Toggle navigation"]
        [:span.icon-bar]
        [:span.icon-bar]
        [:span.icon-bar]]

       `[:a.navbar-brand {:href "/#"}
         [:img {:src "/images/ca1.png"}] ~@ca-logo]]

      [:div#left-navbar.navbar-collapse.collapse
       [:ul {:class "nav navbar-nav"}
        [:li [:a {:href "/#why"} "Rationale"]]
        [:li [:a {:href "/#get-started"} "Get started"]]
        [:li [:a {:href "/#tools"} "Tools"]]
        [:li [:a {:href "/#apps"} "Applications"]]
        [:li [:a {:href "/#community"} "Community"]]]]

      [:div#right-navbar.navbar-collapse.collapse
       [:ul.nav.navbar-nav
        [:li [:a {:href "/blog"} "Blog"]]]]]]

    (when (or (= (:type metadata) :post)
              (:show-blog-nav metadata))
     [:div.container
      [:ul.nav.nav-pills {:style "float:left;"}
       [:li (if (= (:title metadata) "Blog")
              {:class "active"} {}) [:a {:href "/blog/"} "Blog home"]]
       [:li (if (= (:title metadata) "Archives")
              {:class "active"} {})
        [:a {:href "/blog/archives.html"} "Archives"]]]
      [:ul.nav.nav-pills {:style "float:right;"}
       [:li {} [:a#rss-feed {:href "/blog/rss-feed"} "RSS feed"]]]])

    ;; Post only
    (if (= (:type metadata) :post)
      [:div.container
       (when (not (:skip-title metadata))
         [:div.entry-title
          [:h2 {:style "float:left"} (:title metadata)]
          [:span.entry-date {:style "float:right"}
           (format-date (:date metadata) "dd.MM.YYYY")]
          [:div.clear]])

       content

       [:div#comments
        [:script {:src "/js/juvia.js", :type "text/javascript"}]]]

      content)

    [:div#footer
     [:div.container
      [:center
       [:p.muted.credit
        [:span "Copyright " blog-timespan " Alex Yakushev. Created with "
         [:a {:href "https://github.com/alexander-yakushev/discharge"} "Discharge"]
         ". All logos are property of their respective owners."]]]]]

    "<!-- Piwik -->
<script type=\"text/javascript\">
  var _paq = _paq || [];
  _paq.push([\"trackPageView\"]);
  _paq.push([\"enableLinkTracking\"]);

  (function() {
    var u=\"http://analytics.bytopia.org/\";
    _paq.push([\"setTrackerUrl\", u+\"piwik.php\"]);
    _paq.push([\"setSiteId\", \"2\"]);
    var d=document, g=d.createElement(\"script\"), s=d.getElementsByTagName(\"script\")[0]; g.type=\"text/javascript\";
    g.defer=true; g.async=true; g.src=u+\"piwik.js\"; s.parentNode.insertBefore(g,s);
  })();
</script>
<!-- End Piwik Code -->"
    ]])
