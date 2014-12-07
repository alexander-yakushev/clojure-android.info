[:site-title "Clojure on Android"
 :site-description "Develop mobile applications with Clojure"
 :site-url "http://clojure-android.info"
 :blog-url "http://clojure.android.info/blog/"
 :site-author "Alexander Yakushev"
 :date-created 2013
 :in-dir "resources/"
 :out-dir "target/clojure-android.info/"
 :default-template "default.clj"
 :encoding "UTF-8"
 :blog-as-index false
 :create-archives false

 :rsync "rsync"
 :host "digitalocean-bytopia"
 :user "unlogic"
 :deploy-dir "/home/www-data/"
 :post-deploy-cmd ["ssh" "digitalocean-bytopia" "/home/www-data/deploy-clojure-android"]

 :emacs "/usr/bin/emacs"
 :emacs-eval [(require 'org) (require 'ox-html) (require 'cl)
              (setq org-export-with-section-numbers nil)
              (setq org-html-footnotes-section "<div id=\"footnotes\">
<p style=\"display:none;\">%s</p>%s</div>")
              (defun org-html-format-footnote-definition (fn)
                (let ((n (car fn)) (def (cdr fn)))
                  (format
                   "<div class=\"footdef\">%s %s</div>\n"
                   (format org-html-footnote-format
                           (let* ((id (format "fn.%s" n))
                                  (href (format " href=\"#fnr.%s\"" n))
                                  (attributes (concat " class=\"footnum\"" href)))
                                 (org-html--anchor id n attributes)))
                   (substring def 21))))]]
