[:site-title "Clojure on Android"
 :site-description "Develop mobile applications with Clojure"
 :site-url "http://clojure-android.info"
 :blog-url "http://clojure.android.info/blog/"
 :rss-file-name "blog/rss-feed"
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
 :emacs-eval [(add-to-list 'load-path "~/.emacs.d/elpa/clojure-mode-20130911.542/")
              (add-to-list 'load-path "~/.emacs.d/elpa/htmlize-20130207.2102/")
              (require 'htmlize)
              (require 'org)
              (require 'ob)
              (require 'clojure-mode)
              (global-font-lock-mode 1)
              (set-face-foreground 'font-lock-string-face "#8abeb7")
              (set-face-foreground 'font-lock-keyword-face "#b294bb")
              (set-face-bold-p 'font-lock-keyword-face nil)
              (set-face-foreground 'font-lock-constant-face "#de935f")
              (set-face-bold-p 'font-lock-constant-face nil)
              (set-face-underline-p 'font-lock-constant-face nil)
              (set-face-foreground 'font-lock-function-name-face "#81a2be")
              (set-face-bold-p 'font-lock-function-name-face nil)
              (set-face-foreground 'font-lock-builtin-face "#b5bd68")
              (set-face-bold-p 'font-lock-builtin-face nil)
              (set-face-foreground 'font-lock-comment-face "#c5c8c6")]]
