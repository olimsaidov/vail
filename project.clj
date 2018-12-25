(defproject telease "0.1.0-SNAPSHOT"
  :description "Telegram Bot API library"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [clj-http "3.9.0"]
                 [hickory "0.7.1"]
                 [cheshire "5.8.0"]
                 [org.clojure/spec.alpha "0.2.168"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]]}})
