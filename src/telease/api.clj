(ns telease.api
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))


(defn- jsonify [params]
  (map (fn [[k v]]
         {:name    (name k)
          :content (if (coll? v) (json/generate-string v) v)})
       params))


(defn- extract-files [media-coll]
  (reduce
    (fn [[acc files] media]
      (if-not (string? (:media media))
        (let [id (str (gensym))]
          [(conj acc (assoc media :media (str "attach://" id)))
           (assoc files id (:media media))])
        [(conj acc media) files]))
    [[] {}]
    media-coll))


(defn- request [method token params]
  (->> {:multipart (jsonify params) :as :json}
       (client/post (str "https://api.telegram.org/bot" token "/" method))
       (:body)))


(defn get-updates [token params]
  (request "getUpdates" token params))

(defn set-webhook [token params]
  (request "setWebhook" token params))

(defn delete-webhook [token params]
  (request "deleteWebhook" token params))

(defn get-webhook-info [token params]
  (request "getWebhookInfo" token params))

(defn get-me [token params]
  (request "getMe" token params))

(defn send-message [token params]
  (request "sendMessage" token params))

(defn forward-message [token params]
  (request "forwardMessage" token params))

(defn send-photo [token params]
  (request "sendPhoto" token params))

(defn send-audio [token params]
  (request "sendAudio" token params))

(defn send-document [token params]
  (request "sendDocument" token params))

(defn send-video [token params]
  (request "sendVideo" token params))

(defn send-animation [token params]
  (request "sendAnimation" token params))

(defn send-voice [token params]
  (request "sendVoice" token params))

(defn send-video-note [token params]
  (request "sendVideoNote" token params))

(defn send-media-group [token params]
  (request "sendMediaGroup"
           token
           (let [[media files] (extract-files (:media params))]
             (-> params (assoc :media media) (merge files)))))

(defn send-location [token params]
  (request "sendLocation" token params))

(defn edit-message-live-location [token params]
  (request "editMessageLiveLocation" token params))

(defn stop-message-live-location [token params]
  (request "stopMessageLiveLocation" token params))

(defn send-venue [token params]
  (request "sendVenue" token params))

(defn send-contact [token params]
  (request "sendContact" token params))

(defn send-chat-action [token params]
  (request "sendChatAction" token params))

(defn get-user-profile-photos [token params]
  (request "getUserProfilePhotos" token params))

(defn get-file [token params]
  (request "getFile" token params))

(defn kick-chat-member [token params]
  (request "kickChatMember" token params))

(defn unban-chat-member [token params]
  (request "unbanChatMember" token params))

(defn restrict-chat-member [token params]
  (request "restrictChatMember" token params))

(defn promote-chat-member [token params]
  (request "promoteChatMember" token params))

(defn export-chat-invite-link [token params]
  (request "exportChatInviteLink" token params))

(defn set-chat-photo [token params]
  (request "setChatPhoto" token params))

(defn delete-chat-photo [token params]
  (request "deleteChatPhoto" token params))

(defn set-chat-title [token params]
  (request "setChatTitle" token params))

(defn set-chat-description [token params]
  (request "setChatDescription" token params))

(defn pin-chat-message [token params]
  (request "pinChatMessage" token params))

(defn unpin-chat-message [token params]
  (request "unpinChatMessage" token params))

(defn leave-chat [token params]
  (request "leaveChat" token params))

(defn get-chat [token params]
  (request "getChat" token params))

(defn get-chat-administrators [token params]
  (request "getChatAdministrators" token params))

(defn get-chat-members-count [token params]
  (request "getChatMembersCount" token params))

(defn get-chat-member [token params]
  (request "getChatMember" token params))

(defn set-chat-sticker-set [token params]
  (request "setChatStickerSet" token params))

(defn delete-chat-sticker-set [token params]
  (request "deleteChatStickerSet" token params))

(defn answer-callback-query [token params]
  (request "answerCallbackQuery" token params))

(defn edit-message-text [token params]
  (request "editMessageText" token params))

(defn edit-message-caption [token params]
  (request "editMessageCaption" token params))

(defn edit-message-media [token params]
  (request "editMessageMedia"
           token
           (if (some? (:media params))
             (let [[[media] files] (extract-files [(:media params)])]
               (-> params (assoc :media media) (merge files)))
             params)))

(defn edit-message-reply-markup [token params]
  (request "editMessageReplyMarkup" token params))

(defn delete-message [token params]
  (request "deleteMessage" token params))

(defn send-sticker [token params]
  (request "sendSticker" token params))

(defn get-sticker-set [token params]
  (request "getStickerSet" token params))

(defn upload-sticker-file [token params]
  (request "uploadStickerFile" token params))

(defn create-new-sticker-set [token params]
  (request "createNewStickerSet" token params))

(defn add-sticker-to-set [token params]
  (request "addStickerToSet" token params))

(defn set-sticker-position-in-set [token params]
  (request "setStickerPositionInSet" token params))

(defn delete-sticker-from-set [token params]
  (request "deleteStickerFromSet" token params))

(defn answer-inline-query [token params]
  (request "answerInlineQuery" token params))

(defn send-invoice [token params]
  (request "sendInvoice" token params))

(defn answer-shipping-query [token params]
  (request "answerShippingQuery" token params))

(defn answer-pre-checkout-query [token params]
  (request "answerPreCheckoutQuery" token params))

(defn set-passport-data-errors [token params]
  (request "setPassportDataErrors" token params))

(defn send-game [token params]
  (request "sendGame" token params))

(defn set-game-score [token params]
  (request "setGameScore" token params))

(defn get-game-high-scores [token params]
  (request "getGameHighScores" token params))

