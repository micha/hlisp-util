(defproject tailrecursion/hlisp-util "0.1.0-SNAPSHOT"
  :description  "FIXME: write description"
  :url          "http://github.com/micha/hlisp-util"
  :license      {:name  "Eclipse Public License"
                 :url   "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies []
  :plugins      [[lein-cljsbuild "0.3.0"]]
  :source-paths ["src/clj" "src/cljs"]
  :cljsbuild    {:test-commands {"unit" ["phantomjs" "test/runner.js"]}
                 :builds {:test {:jar           false
                                 :source-paths  ["src/clj" "src/cljs" "test"]
                                 :compiler      {:output-to "test/test.js"
                                                 :optimizations :advanced
                                                 :warnings true
                                                 ;; :optimizations :whitespace
                                                 ;; :pretty-print true
                                                 }}}})
