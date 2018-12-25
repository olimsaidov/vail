(ns telease.schema
  (:require [clojure.spec.alpha :as s]
            [telease.api :as api]))



(s/def :telegram/CallbackGame any?)
(s/def :telegram/Message any?)
(s/def :telegram/Chat any?)
(s/def :telegram/InputFile any?)



(s/def :telegram/WebhookInfo.url string?)
(s/def :telegram/WebhookInfo.has_custom_certificate boolean?)
(s/def :telegram/WebhookInfo.pending_update_count integer?)
(s/def :telegram/WebhookInfo.last_error_date integer?)
(s/def :telegram/WebhookInfo.last_error_message string?)
(s/def :telegram/WebhookInfo.max_connections integer?)
(s/def :telegram/WebhookInfo.allowed_updates (s/coll-of string?))
(s/def :telegram/WebhookInfo
  (s/keys :req-un [:telegram/WebhookInfo.last_error_date
                   :telegram/WebhookInfo.last_error_message
                   :telegram/WebhookInfo.max_connections
                   :telegram/WebhookInfo.allowed_updates]
          :opt-un [:telegram/WebhookInfo.url
                   :telegram/WebhookInfo.has_custom_certificate
                   :telegram/WebhookInfo.pending_update_count]))



(s/def :telegram/User.id integer?)
(s/def :telegram/User.is_bot boolean?)
(s/def :telegram/User.first_name string?)
(s/def :telegram/User.last_name string?)
(s/def :telegram/User.username string?)
(s/def :telegram/User.language_code string?)
(s/def :telegram/User
  (s/keys :req-un [:telegram/User.last_name
                   :telegram/User.username
                   :telegram/User.language_code]
          :opt-un [:telegram/User.id
                   :telegram/User.is_bot
                   :telegram/User.first_name]))



(s/def :telegram/ChatPhoto.small_file_id string?)
(s/def :telegram/ChatPhoto.big_file_id string?)
(s/def :telegram/ChatPhoto
  (s/keys :opt-un [:telegram/ChatPhoto.small_file_id
                   :telegram/ChatPhoto.big_file_id]))



(s/def :telegram/MessageEntity.type
  #{"mention" "hashtag" "cashtag" "bot_command" "url" "email" "phone_number"
    "bold" "italic" "code" "pre" "text_link" "text_mention"})
(s/def :telegram/MessageEntity.offset integer?)
(s/def :telegram/MessageEntity.length integer?)
(s/def :telegram/MessageEntity.url string?)
(s/def :telegram/MessageEntity.user :telegram/User)
(s/def :telegram/MessageEntity
  (s/keys :req-un [:telegram/MessageEntity.url
                   :telegram/MessageEntity.user]
          :opt-un [:telegram/MessageEntity.type
                   :telegram/MessageEntity.offset
                   :telegram/MessageEntity.length]))



(s/def :telegram/PhotoSize.file_id string?)
(s/def :telegram/PhotoSize.width integer?)
(s/def :telegram/PhotoSize.height integer?)
(s/def :telegram/PhotoSize.file_size integer?)
(s/def :telegram/PhotoSize
  (s/keys :req-un [:telegram/PhotoSize.file_size]
          :opt-un [:telegram/PhotoSize.file_id
                   :telegram/PhotoSize.width
                   :telegram/PhotoSize.height]))



(s/def :telegram/Audio.file_id string?)
(s/def :telegram/Audio.duration integer?)
(s/def :telegram/Audio.performer string?)
(s/def :telegram/Audio.title string?)
(s/def :telegram/Audio.mime_type string?)
(s/def :telegram/Audio.file_size integer?)
(s/def :telegram/Audio.thumb :telegram/PhotoSize)
(s/def :telegram/Audio
  (s/keys :req-un [:telegram/Audio.performer
                   :telegram/Audio.title
                   :telegram/Audio.mime_type
                   :telegram/Audio.file_size
                   :telegram/Audio.thumb]
          :opt-un [:telegram/Audio.file_id
                   :telegram/Audio.duration]))



(s/def :telegram/Document.file_id string?)
(s/def :telegram/Document.thumb :telegram/PhotoSize)
(s/def :telegram/Document.file_name string?)
(s/def :telegram/Document.mime_type string?)
(s/def :telegram/Document.file_size integer?)
(s/def :telegram/Document
  (s/keys :req-un [:telegram/Document.thumb
                   :telegram/Document.file_name
                   :telegram/Document.mime_type
                   :telegram/Document.file_size]
          :opt-un [:telegram/Document.file_id]))



(s/def :telegram/Video.file_id string?)
(s/def :telegram/Video.width integer?)
(s/def :telegram/Video.height integer?)
(s/def :telegram/Video.duration integer?)
(s/def :telegram/Video.thumb :telegram/PhotoSize)
(s/def :telegram/Video.mime_type string?)
(s/def :telegram/Video.file_size integer?)
(s/def :telegram/Video
  (s/keys :req-un [:telegram/Video.thumb
                   :telegram/Video.mime_type
                   :telegram/Video.file_size]
          :opt-un [:telegram/Video.file_id
                   :telegram/Video.width
                   :telegram/Video.height
                   :telegram/Video.duration]))



(s/def :telegram/Animation.file_id string?)
(s/def :telegram/Animation.width integer?)
(s/def :telegram/Animation.height integer?)
(s/def :telegram/Animation.duration integer?)
(s/def :telegram/Animation.thumb :telegram/PhotoSize)
(s/def :telegram/Animation.file_name string?)
(s/def :telegram/Animation.mime_type string?)
(s/def :telegram/Animation.file_size integer?)
(s/def :telegram/Animation
  (s/keys :req-un [:telegram/Animation.thumb
                   :telegram/Animation.file_name
                   :telegram/Animation.mime_type
                   :telegram/Animation.file_size]
          :opt-un [:telegram/Animation.file_id
                   :telegram/Animation.width
                   :telegram/Animation.height
                   :telegram/Animation.duration]))



(s/def :telegram/Voice.file_id string?)
(s/def :telegram/Voice.duration integer?)
(s/def :telegram/Voice.mime_type string?)
(s/def :telegram/Voice.file_size integer?)
(s/def :telegram/Voice
  (s/keys :req-un [:telegram/Voice.mime_type
                   :telegram/Voice.file_size]
          :opt-un [:telegram/Voice.file_id
                   :telegram/Voice.duration]))



(s/def :telegram/VideoNote.file_id string?)
(s/def :telegram/VideoNote.length integer?)
(s/def :telegram/VideoNote.duration integer?)
(s/def :telegram/VideoNote.thumb :telegram/PhotoSize)
(s/def :telegram/VideoNote.file_size integer?)
(s/def :telegram/VideoNote
  (s/keys :req-un [:telegram/VideoNote.thumb
                   :telegram/VideoNote.file_size]
          :opt-un [:telegram/VideoNote.file_id
                   :telegram/VideoNote.length
                   :telegram/VideoNote.duration]))



(s/def :telegram/Contact.phone_number string?)
(s/def :telegram/Contact.first_name string?)
(s/def :telegram/Contact.last_name string?)
(s/def :telegram/Contact.user_id integer?)
(s/def :telegram/Contact.vcard string?)
(s/def :telegram/Contact
  (s/keys :req-un [:telegram/Contact.last_name
                   :telegram/Contact.user_id
                   :telegram/Contact.vcard]
          :opt-un [:telegram/Contact.phone_number
                   :telegram/Contact.first_name]))



(s/def :telegram/Location.longitude float?)
(s/def :telegram/Location.latitude float?)
(s/def :telegram/Location
  (s/keys :opt-un [:telegram/Location.longitude
                   :telegram/Location.latitude]))



(s/def :telegram/Venue.location :telegram/Location)
(s/def :telegram/Venue.title string?)
(s/def :telegram/Venue.address string?)
(s/def :telegram/Venue.foursquare_id string?)
(s/def :telegram/Venue.foursquare_type string?)
(s/def :telegram/Venue
  (s/keys :req-un [:telegram/Venue.foursquare_id
                   :telegram/Venue.foursquare_type]
          :opt-un [:telegram/Venue.location
                   :telegram/Venue.title
                   :telegram/Venue.address]))



(s/def :telegram/UserProfilePhotos.total_count integer?)
(s/def :telegram/UserProfilePhotos.photos (s/coll-of (s/coll-of :telegram/PhotoSize)))
(s/def :telegram/UserProfilePhotos
  (s/keys :opt-un [:telegram/UserProfilePhotos.total_count
                   :telegram/UserProfilePhotos.photos]))



(s/def :telegram/File.file_id string?)
(s/def :telegram/File.file_size integer?)
(s/def :telegram/File.file_path string?)
(s/def :telegram/File
  (s/keys :req-un [:telegram/File.file_size :telegram/File.file_path]
          :opt-un [:telegram/File.file_id]))



(s/def :telegram/ReplyKeyboardMarkup.keyboard (s/coll-of (s/coll-of :telegram/KeyboardButton)))
(s/def :telegram/ReplyKeyboardMarkup.resize_keyboard boolean?)
(s/def :telegram/ReplyKeyboardMarkup.one_time_keyboard boolean?)
(s/def :telegram/ReplyKeyboardMarkup.selective boolean?)
(s/def :telegram/ReplyKeyboardMarkup
  (s/keys :req-un [:telegram/ReplyKeyboardMarkup.resize_keyboard
                   :telegram/ReplyKeyboardMarkup.one_time_keyboard
                   :telegram/ReplyKeyboardMarkup.selective]
          :opt-un [:telegram/ReplyKeyboardMarkup.keyboard]))



(s/def :telegram/KeyboardButton.text string?)
(s/def :telegram/KeyboardButton.request_contact boolean?)
(s/def :telegram/KeyboardButton.request_location boolean?)
(s/def :telegram/KeyboardButton
  (s/keys :req-un [:telegram/KeyboardButton.request_contact
                   :telegram/KeyboardButton.request_location]
          :opt-un [:telegram/KeyboardButton.text]))



(s/def :telegram/ReplyKeyboardRemove.remove_keyboard #{true})
(s/def :telegram/ReplyKeyboardRemove.selective boolean?)
(s/def :telegram/ReplyKeyboardRemove
  (s/keys :req-un [:telegram/ReplyKeyboardRemove.selective]
          :opt-un [:telegram/ReplyKeyboardRemove.remove_keyboard]))



(s/def :telegram/InlineKeyboardMarkup.inline_keyboard (s/coll-of (s/coll-of :telegram/InlineKeyboardButton)))
(s/def :telegram/InlineKeyboardMarkup
  (s/keys :opt-un [:telegram/InlineKeyboardMarkup.inline_keyboard]))



(s/def :telegram/InlineKeyboardButton.text string?)
(s/def :telegram/InlineKeyboardButton.url string?)
(s/def :telegram/InlineKeyboardButton.callback_data string?)
(s/def :telegram/InlineKeyboardButton.switch_inline_query string?)
(s/def :telegram/InlineKeyboardButton.switch_inline_query_current_chat string?)
(s/def :telegram/InlineKeyboardButton.callback_game :telegram/CallbackGame)
(s/def :telegram/InlineKeyboardButton.pay boolean?)
(s/def :telegram/InlineKeyboardButton
  (s/keys :req-un [:telegram/InlineKeyboardButton.url
                   :telegram/InlineKeyboardButton.callback_data
                   :telegram/InlineKeyboardButton.switch_inline_query
                   :telegram/InlineKeyboardButton.switch_inline_query_current_chat
                   :telegram/InlineKeyboardButton.callback_game
                   :telegram/InlineKeyboardButton.pay]
          :opt-un [:telegram/InlineKeyboardButton.text]))



(s/def :telegram/CallbackQuery.id string?)
(s/def :telegram/CallbackQuery.from :telegram/User)
(s/def :telegram/CallbackQuery.message :telegram/Message)
(s/def :telegram/CallbackQuery.inline_message_id string?)
(s/def :telegram/CallbackQuery.chat_instance string?)
(s/def :telegram/CallbackQuery.data string?)
(s/def :telegram/CallbackQuery.game_short_name string?)
(s/def :telegram/CallbackQuery
  (s/keys :req-un [:telegram/CallbackQuery.message
                   :telegram/CallbackQuery.inline_message_id
                   :telegram/CallbackQuery.data
                   :telegram/CallbackQuery.game_short_name]
          :opt-un [:telegram/CallbackQuery.id
                   :telegram/CallbackQuery.from
                   :telegram/CallbackQuery.chat_instance]))



(s/def :telegram/ForceReply.force_reply #{true})
(s/def :telegram/ForceReply.selective boolean?)
(s/def :telegram/ForceReply
  (s/keys :req-un [:telegram/ForceReply.selective]
          :opt-un [:telegram/ForceReply.force_reply]))



(s/def :telegram/ChatMember.user :telegram/User)
(s/def :telegram/ChatMember.status #{"creator" "administrator" "member" "restricted" "left" "kicked"})
(s/def :telegram/ChatMember.until_date integer?)
(s/def :telegram/ChatMember.can_be_edited boolean?)
(s/def :telegram/ChatMember.can_change_info boolean?)
(s/def :telegram/ChatMember.can_post_messages boolean?)
(s/def :telegram/ChatMember.can_edit_messages boolean?)
(s/def :telegram/ChatMember.can_delete_messages boolean?)
(s/def :telegram/ChatMember.can_invite_users boolean?)
(s/def :telegram/ChatMember.can_restrict_members boolean?)
(s/def :telegram/ChatMember.can_pin_messages boolean?)
(s/def :telegram/ChatMember.can_promote_members boolean?)
(s/def :telegram/ChatMember.can_send_messages boolean?)
(s/def :telegram/ChatMember.can_send_media_messages boolean?)
(s/def :telegram/ChatMember.can_send_other_messages boolean?)
(s/def :telegram/ChatMember.can_add_web_page_previews boolean?)
(s/def :telegram/ChatMember
  (s/keys :req-un [:telegram/ChatMember.until_date
                   :telegram/ChatMember.can_be_edited
                   :telegram/ChatMember.can_change_info
                   :telegram/ChatMember.can_post_messages
                   :telegram/ChatMember.can_edit_messages
                   :telegram/ChatMember.can_delete_messages
                   :telegram/ChatMember.can_invite_users
                   :telegram/ChatMember.can_restrict_members
                   :telegram/ChatMember.can_pin_messages
                   :telegram/ChatMember.can_promote_members
                   :telegram/ChatMember.can_send_messages
                   :telegram/ChatMember.can_send_media_messages
                   :telegram/ChatMember.can_send_other_messages
                   :telegram/ChatMember.can_add_web_page_previews]
          :opt-un [:telegram/ChatMember.user
                   :telegram/ChatMember.status]))



(s/def :telegram/ResponseParameters.migrate_to_chat_id integer?)
(s/def :telegram/ResponseParameters.retry_after integer?)
(s/def :telegram/ResponseParameters
  (s/keys :req-un [:telegram/ResponseParameters.migrate_to_chat_id
                   :telegram/ResponseParameters.retry_after]))



(s/def :telegram/InputMediaPhoto.type string?)
(s/def :telegram/InputMediaPhoto.media string?)
(s/def :telegram/InputMediaPhoto.caption string?)
(s/def :telegram/InputMediaPhoto.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InputMediaPhoto
  (s/keys :req-un [:telegram/InputMediaPhoto.caption
                   :telegram/InputMediaPhoto.parse_mode]
          :opt-un [:telegram/InputMediaPhoto.type
                   :telegram/InputMediaPhoto.media]))



(s/def :telegram/InputMediaVideo.type string?)
(s/def :telegram/InputMediaVideo.media string?)
(s/def :telegram/InputMediaVideo.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/InputMediaVideo.caption string?)
(s/def :telegram/InputMediaVideo.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InputMediaVideo.width integer?)
(s/def :telegram/InputMediaVideo.height integer?)
(s/def :telegram/InputMediaVideo.duration integer?)
(s/def :telegram/InputMediaVideo.supports_streaming boolean?)
(s/def :telegram/InputMediaVideo
  (s/keys :req-un [:telegram/InputMediaVideo.thumb
                   :telegram/InputMediaVideo.caption
                   :telegram/InputMediaVideo.parse_mode
                   :telegram/InputMediaVideo.width
                   :telegram/InputMediaVideo.height
                   :telegram/InputMediaVideo.duration
                   :telegram/InputMediaVideo.supports_streaming]
          :opt-un [:telegram/InputMediaVideo.type
                   :telegram/InputMediaVideo.media]))



(s/def :telegram/InputMediaAnimation.type string?)
(s/def :telegram/InputMediaAnimation.media string?)
(s/def :telegram/InputMediaAnimation.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/InputMediaAnimation.caption string?)
(s/def :telegram/InputMediaAnimation.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InputMediaAnimation.width integer?)
(s/def :telegram/InputMediaAnimation.height integer?)
(s/def :telegram/InputMediaAnimation.duration integer?)
(s/def :telegram/InputMediaAnimation
  (s/keys :req-un [:telegram/InputMediaAnimation.thumb
                   :telegram/InputMediaAnimation.caption
                   :telegram/InputMediaAnimation.parse_mode
                   :telegram/InputMediaAnimation.width
                   :telegram/InputMediaAnimation.height
                   :telegram/InputMediaAnimation.duration]
          :opt-un [:telegram/InputMediaAnimation.type
                   :telegram/InputMediaAnimation.media]))



(s/def :telegram/InputMediaAudio.type string?)
(s/def :telegram/InputMediaAudio.media string?)
(s/def :telegram/InputMediaAudio.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/InputMediaAudio.caption string?)
(s/def :telegram/InputMediaAudio.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InputMediaAudio.duration integer?)
(s/def :telegram/InputMediaAudio.performer string?)
(s/def :telegram/InputMediaAudio.title string?)
(s/def :telegram/InputMediaAudio
  (s/keys :req-un [:telegram/InputMediaAudio.thumb
                   :telegram/InputMediaAudio.caption
                   :telegram/InputMediaAudio.parse_mode
                   :telegram/InputMediaAudio.duration
                   :telegram/InputMediaAudio.performer
                   :telegram/InputMediaAudio.title]
          :opt-un [:telegram/InputMediaAudio.type
                   :telegram/InputMediaAudio.media]))



(s/def :telegram/InputMediaDocument.type string?)
(s/def :telegram/InputMediaDocument.media string?)
(s/def :telegram/InputMediaDocument.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/InputMediaDocument.caption string?)
(s/def :telegram/InputMediaDocument.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InputMediaDocument
  (s/keys :req-un [:telegram/InputMediaDocument.thumb
                   :telegram/InputMediaDocument.caption
                   :telegram/InputMediaDocument.parse_mode]
          :opt-un [:telegram/InputMediaDocument.type
                   :telegram/InputMediaDocument.media]))




(s/def :telegram/InputMedia
  (s/or :InputMediaAnimation :telegram/InputMediaAnimation
        :InputMediaDocument :telegram/InputMediaDocument
        :InputMediaAudio :telegram/InputMediaAudio
        :InputMediaPhoto :telegram/InputMediaPhoto
        :InputMediaVideo :telegram/InputMediaVideo))




(s/def :telegram/MaskPosition.point #{"forehead" "eyes" "mouth" "chin"})
(s/def :telegram/MaskPosition.x_shift float?)
(s/def :telegram/MaskPosition.y_shift float?)
(s/def :telegram/MaskPosition.scale float?)
(s/def :telegram/MaskPosition
  (s/keys
    :opt-un [:telegram/MaskPosition.point
             :telegram/MaskPosition.x_shift
             :telegram/MaskPosition.y_shift
             :telegram/MaskPosition.scale]))



(s/def :telegram/Sticker.file_id string?)
(s/def :telegram/Sticker.width integer?)
(s/def :telegram/Sticker.height integer?)
(s/def :telegram/Sticker.thumb :telegram/PhotoSize)
(s/def :telegram/Sticker.emoji string?)
(s/def :telegram/Sticker.set_name string?)
(s/def :telegram/Sticker.mask_position :telegram/MaskPosition)
(s/def :telegram/Sticker.file_size integer?)
(s/def :telegram/Sticker
  (s/keys :req-un [:telegram/Sticker.thumb
                   :telegram/Sticker.emoji
                   :telegram/Sticker.set_name
                   :telegram/Sticker.mask_position
                   :telegram/Sticker.file_size]
          :opt-un [:telegram/Sticker.file_id
                   :telegram/Sticker.width
                   :telegram/Sticker.height]))



(s/def :telegram/StickerSet.name string?)
(s/def :telegram/StickerSet.title string?)
(s/def :telegram/StickerSet.contains_masks boolean?)
(s/def :telegram/StickerSet.stickers (s/coll-of :telegram/Sticker))
(s/def :telegram/StickerSet
  (s/keys
    :opt-un [:telegram/StickerSet.name
             :telegram/StickerSet.title
             :telegram/StickerSet.contains_masks
             :telegram/StickerSet.stickers]))




(s/def :telegram/InputTextMessageContent.message_text string?)
(s/def :telegram/InputTextMessageContent.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InputTextMessageContent.disable_web_page_preview boolean?)
(s/def :telegram/InputTextMessageContent
  (s/keys :req-un [:telegram/InputTextMessageContent.parse_mode
                   :telegram/InputTextMessageContent.disable_web_page_preview]
          :opt-un [:telegram/InputTextMessageContent.message_text]))



(s/def :telegram/InputLocationMessageContent.latitude float?)
(s/def :telegram/InputLocationMessageContent.longitude float?)
(s/def :telegram/InputLocationMessageContent.live_period integer?)
(s/def :telegram/InputLocationMessageContent
  (s/keys :req-un [:telegram/InputLocationMessageContent.live_period]
          :opt-un [:telegram/InputLocationMessageContent.latitude
                   :telegram/InputLocationMessageContent.longitude]))



(s/def :telegram/InputVenueMessageContent.latitude float?)
(s/def :telegram/InputVenueMessageContent.longitude float?)
(s/def :telegram/InputVenueMessageContent.title string?)
(s/def :telegram/InputVenueMessageContent.address string?)
(s/def :telegram/InputVenueMessageContent.foursquare_id string?)
(s/def :telegram/InputVenueMessageContent.foursquare_type string?)
(s/def :telegram/InputVenueMessageContent
  (s/keys :req-un [:telegram/InputVenueMessageContent.foursquare_id
                   :telegram/InputVenueMessageContent.foursquare_type]
          :opt-un [:telegram/InputVenueMessageContent.latitude
                   :telegram/InputVenueMessageContent.longitude
                   :telegram/InputVenueMessageContent.title
                   :telegram/InputVenueMessageContent.address]))



(s/def :telegram/InputContactMessageContent.phone_number string?)
(s/def :telegram/InputContactMessageContent.first_name string?)
(s/def :telegram/InputContactMessageContent.last_name string?)
(s/def :telegram/InputContactMessageContent.vcard string?)
(s/def :telegram/InputContactMessageContent
  (s/keys :req-un [:telegram/InputContactMessageContent.last_name
                   :telegram/InputContactMessageContent.vcard]
          :opt-un [:telegram/InputContactMessageContent.phone_number
                   :telegram/InputContactMessageContent.first_name]))



(s/def :telegram/InputMessageContent
  (s/or :InputTextMessageContent :telegram/InputTextMessageContent
        :InputLocationMessageContent :telegram/InputLocationMessageContent
        :InputVenueMessageContent :telegram/InputVenueMessageContent
        :InputContactMessageContent :telegram/InputContactMessageContent))



(s/def :telegram/InlineQuery.id string?)
(s/def :telegram/InlineQuery.from :telegram/User)
(s/def :telegram/InlineQuery.location :telegram/Location)
(s/def :telegram/InlineQuery.query string?)
(s/def :telegram/InlineQuery.offset string?)
(s/def :telegram/InlineQuery
  (s/keys :req-un [:telegram/InlineQuery.location]
          :opt-un [:telegram/InlineQuery.id
                   :telegram/InlineQuery.from
                   :telegram/InlineQuery.query
                   :telegram/InlineQuery.offset]))



(s/def :telegram/InlineQueryResultArticle.type string?)
(s/def :telegram/InlineQueryResultArticle.id string?)
(s/def :telegram/InlineQueryResultArticle.title string?)
(s/def :telegram/InlineQueryResultArticle.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultArticle.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultArticle.url string?)
(s/def :telegram/InlineQueryResultArticle.hide_url boolean?)
(s/def :telegram/InlineQueryResultArticle.description string?)
(s/def :telegram/InlineQueryResultArticle.thumb_url string?)
(s/def :telegram/InlineQueryResultArticle.thumb_width integer?)
(s/def :telegram/InlineQueryResultArticle.thumb_height integer?)
(s/def :telegram/InlineQueryResultArticle
  (s/keys :req-un [:telegram/InlineQueryResultArticle.reply_markup
                   :telegram/InlineQueryResultArticle.url
                   :telegram/InlineQueryResultArticle.hide_url
                   :telegram/InlineQueryResultArticle.description
                   :telegram/InlineQueryResultArticle.thumb_url
                   :telegram/InlineQueryResultArticle.thumb_width
                   :telegram/InlineQueryResultArticle.thumb_height]
          :opt-un [:telegram/InlineQueryResultArticle.type
                   :telegram/InlineQueryResultArticle.id
                   :telegram/InlineQueryResultArticle.title
                   :telegram/InlineQueryResultArticle.input_message_content]))



(s/def :telegram/InlineQueryResultPhoto.type string?)
(s/def :telegram/InlineQueryResultPhoto.id string?)
(s/def :telegram/InlineQueryResultPhoto.photo_url string?)
(s/def :telegram/InlineQueryResultPhoto.thumb_url string?)
(s/def :telegram/InlineQueryResultPhoto.photo_width integer?)
(s/def :telegram/InlineQueryResultPhoto.photo_height integer?)
(s/def :telegram/InlineQueryResultPhoto.title string?)
(s/def :telegram/InlineQueryResultPhoto.description string?)
(s/def :telegram/InlineQueryResultPhoto.caption string?)
(s/def :telegram/InlineQueryResultPhoto.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultPhoto.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultPhoto.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultPhoto
  (s/keys :req-un [:telegram/InlineQueryResultPhoto.photo_width
                   :telegram/InlineQueryResultPhoto.photo_height
                   :telegram/InlineQueryResultPhoto.title
                   :telegram/InlineQueryResultPhoto.description
                   :telegram/InlineQueryResultPhoto.caption
                   :telegram/InlineQueryResultPhoto.parse_mode
                   :telegram/InlineQueryResultPhoto.reply_markup
                   :telegram/InlineQueryResultPhoto.input_message_content]
          :opt-un [:telegram/InlineQueryResultPhoto.type
                   :telegram/InlineQueryResultPhoto.id
                   :telegram/InlineQueryResultPhoto.photo_url
                   :telegram/InlineQueryResultPhoto.thumb_url]))



(s/def :telegram/InlineQueryResultGif.type string?)
(s/def :telegram/InlineQueryResultGif.id string?)
(s/def :telegram/InlineQueryResultGif.gif_url string?)
(s/def :telegram/InlineQueryResultGif.gif_width integer?)
(s/def :telegram/InlineQueryResultGif.gif_height integer?)
(s/def :telegram/InlineQueryResultGif.gif_duration integer?)
(s/def :telegram/InlineQueryResultGif.thumb_url string?)
(s/def :telegram/InlineQueryResultGif.title string?)
(s/def :telegram/InlineQueryResultGif.caption string?)
(s/def :telegram/InlineQueryResultGif.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultGif.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultGif.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultGif
  (s/keys :req-un [:telegram/InlineQueryResultGif.gif_width
                   :telegram/InlineQueryResultGif.gif_height
                   :telegram/InlineQueryResultGif.gif_duration
                   :telegram/InlineQueryResultGif.title
                   :telegram/InlineQueryResultGif.caption
                   :telegram/InlineQueryResultGif.parse_mode
                   :telegram/InlineQueryResultGif.reply_markup
                   :telegram/InlineQueryResultGif.input_message_content]
          :opt-un [:telegram/InlineQueryResultGif.type
                   :telegram/InlineQueryResultGif.id
                   :telegram/InlineQueryResultGif.gif_url
                   :telegram/InlineQueryResultGif.thumb_url]))



(s/def :telegram/InlineQueryResultMpeg4Gif.type string?)
(s/def :telegram/InlineQueryResultMpeg4Gif.id string?)
(s/def :telegram/InlineQueryResultMpeg4Gif.mpeg4_url string?)
(s/def :telegram/InlineQueryResultMpeg4Gif.mpeg4_width integer?)
(s/def :telegram/InlineQueryResultMpeg4Gif.mpeg4_height integer?)
(s/def :telegram/InlineQueryResultMpeg4Gif.mpeg4_duration integer?)
(s/def :telegram/InlineQueryResultMpeg4Gif.thumb_url string?)
(s/def :telegram/InlineQueryResultMpeg4Gif.title string?)
(s/def :telegram/InlineQueryResultMpeg4Gif.caption string?)
(s/def :telegram/InlineQueryResultMpeg4Gif.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultMpeg4Gif.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultMpeg4Gif.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultMpeg4Gif
  (s/keys :req-un [:telegram/InlineQueryResultMpeg4Gif.mpeg4_width
                   :telegram/InlineQueryResultMpeg4Gif.mpeg4_height
                   :telegram/InlineQueryResultMpeg4Gif.mpeg4_duration
                   :telegram/InlineQueryResultMpeg4Gif.title
                   :telegram/InlineQueryResultMpeg4Gif.caption
                   :telegram/InlineQueryResultMpeg4Gif.parse_mode
                   :telegram/InlineQueryResultMpeg4Gif.reply_markup
                   :telegram/InlineQueryResultMpeg4Gif.input_message_content]
          :opt-un [:telegram/InlineQueryResultMpeg4Gif.type
                   :telegram/InlineQueryResultMpeg4Gif.id
                   :telegram/InlineQueryResultMpeg4Gif.mpeg4_url
                   :telegram/InlineQueryResultMpeg4Gif.thumb_url]))



(s/def :telegram/InlineQueryResultVideo.type string?)
(s/def :telegram/InlineQueryResultVideo.id string?)
(s/def :telegram/InlineQueryResultVideo.video_url string?)
(s/def :telegram/InlineQueryResultVideo.mime_type #{"text/html" "video/mp4"})
(s/def :telegram/InlineQueryResultVideo.thumb_url string?)
(s/def :telegram/InlineQueryResultVideo.title string?)
(s/def :telegram/InlineQueryResultVideo.caption string?)
(s/def :telegram/InlineQueryResultVideo.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultVideo.video_width integer?)
(s/def :telegram/InlineQueryResultVideo.video_height integer?)
(s/def :telegram/InlineQueryResultVideo.video_duration integer?)
(s/def :telegram/InlineQueryResultVideo.description string?)
(s/def :telegram/InlineQueryResultVideo.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultVideo.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultVideo
  (s/keys :req-un [:telegram/InlineQueryResultVideo.caption
                   :telegram/InlineQueryResultVideo.parse_mode
                   :telegram/InlineQueryResultVideo.video_width
                   :telegram/InlineQueryResultVideo.video_height
                   :telegram/InlineQueryResultVideo.video_duration
                   :telegram/InlineQueryResultVideo.description
                   :telegram/InlineQueryResultVideo.reply_markup
                   :telegram/InlineQueryResultVideo.input_message_content]
          :opt-un [:telegram/InlineQueryResultVideo.type
                   :telegram/InlineQueryResultVideo.id
                   :telegram/InlineQueryResultVideo.video_url
                   :telegram/InlineQueryResultVideo.mime_type
                   :telegram/InlineQueryResultVideo.thumb_url
                   :telegram/InlineQueryResultVideo.title]))



(s/def :telegram/InlineQueryResultAudio.type string?)
(s/def :telegram/InlineQueryResultAudio.id string?)
(s/def :telegram/InlineQueryResultAudio.audio_url string?)
(s/def :telegram/InlineQueryResultAudio.title string?)
(s/def :telegram/InlineQueryResultAudio.caption string?)
(s/def :telegram/InlineQueryResultAudio.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultAudio.performer string?)
(s/def :telegram/InlineQueryResultAudio.audio_duration integer?)
(s/def :telegram/InlineQueryResultAudio.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultAudio.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultAudio
  (s/keys :req-un [:telegram/InlineQueryResultAudio.caption
                   :telegram/InlineQueryResultAudio.parse_mode
                   :telegram/InlineQueryResultAudio.performer
                   :telegram/InlineQueryResultAudio.audio_duration
                   :telegram/InlineQueryResultAudio.reply_markup
                   :telegram/InlineQueryResultAudio.input_message_content]
          :opt-un [:telegram/InlineQueryResultAudio.type
                   :telegram/InlineQueryResultAudio.id
                   :telegram/InlineQueryResultAudio.audio_url
                   :telegram/InlineQueryResultAudio.title]))



(s/def :telegram/InlineQueryResultVoice.type string?)
(s/def :telegram/InlineQueryResultVoice.id string?)
(s/def :telegram/InlineQueryResultVoice.voice_url string?)
(s/def :telegram/InlineQueryResultVoice.title string?)
(s/def :telegram/InlineQueryResultVoice.caption string?)
(s/def :telegram/InlineQueryResultVoice.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultVoice.voice_duration integer?)
(s/def :telegram/InlineQueryResultVoice.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultVoice.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultVoice
  (s/keys :req-un [:telegram/InlineQueryResultVoice.caption
                   :telegram/InlineQueryResultVoice.parse_mode
                   :telegram/InlineQueryResultVoice.voice_duration
                   :telegram/InlineQueryResultVoice.reply_markup
                   :telegram/InlineQueryResultVoice.input_message_content]
          :opt-un [:telegram/InlineQueryResultVoice.type
                   :telegram/InlineQueryResultVoice.id
                   :telegram/InlineQueryResultVoice.voice_url
                   :telegram/InlineQueryResultVoice.title]))



(s/def :telegram/InlineQueryResultDocument.type string?)
(s/def :telegram/InlineQueryResultDocument.id string?)
(s/def :telegram/InlineQueryResultDocument.title string?)
(s/def :telegram/InlineQueryResultDocument.caption string?)
(s/def :telegram/InlineQueryResultDocument.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultDocument.document_url string?)
(s/def :telegram/InlineQueryResultDocument.mime_type #{"application/pdf" "application/zip"})
(s/def :telegram/InlineQueryResultDocument.description string?)
(s/def :telegram/InlineQueryResultDocument.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultDocument.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultDocument.thumb_url string?)
(s/def :telegram/InlineQueryResultDocument.thumb_width integer?)
(s/def :telegram/InlineQueryResultDocument.thumb_height integer?)
(s/def :telegram/InlineQueryResultDocument
  (s/keys :req-un [:telegram/InlineQueryResultDocument.caption
                   :telegram/InlineQueryResultDocument.parse_mode
                   :telegram/InlineQueryResultDocument.description
                   :telegram/InlineQueryResultDocument.reply_markup
                   :telegram/InlineQueryResultDocument.input_message_content
                   :telegram/InlineQueryResultDocument.thumb_url
                   :telegram/InlineQueryResultDocument.thumb_width
                   :telegram/InlineQueryResultDocument.thumb_height]
          :opt-un [:telegram/InlineQueryResultDocument.type
                   :telegram/InlineQueryResultDocument.id
                   :telegram/InlineQueryResultDocument.title
                   :telegram/InlineQueryResultDocument.document_url
                   :telegram/InlineQueryResultDocument.mime_type]))



(s/def :telegram/InlineQueryResultLocation.type string?)
(s/def :telegram/InlineQueryResultLocation.id string?)
(s/def :telegram/InlineQueryResultLocation.latitude float?)
(s/def :telegram/InlineQueryResultLocation.longitude float?)
(s/def :telegram/InlineQueryResultLocation.title string?)
(s/def :telegram/InlineQueryResultLocation.live_period integer?)
(s/def :telegram/InlineQueryResultLocation.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultLocation.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultLocation.thumb_url string?)
(s/def :telegram/InlineQueryResultLocation.thumb_width integer?)
(s/def :telegram/InlineQueryResultLocation.thumb_height integer?)
(s/def :telegram/InlineQueryResultLocation
  (s/keys :req-un [:telegram/InlineQueryResultLocation.live_period
                   :telegram/InlineQueryResultLocation.reply_markup
                   :telegram/InlineQueryResultLocation.input_message_content
                   :telegram/InlineQueryResultLocation.thumb_url
                   :telegram/InlineQueryResultLocation.thumb_width
                   :telegram/InlineQueryResultLocation.thumb_height]
          :opt-un [:telegram/InlineQueryResultLocation.type
                   :telegram/InlineQueryResultLocation.id
                   :telegram/InlineQueryResultLocation.latitude
                   :telegram/InlineQueryResultLocation.longitude
                   :telegram/InlineQueryResultLocation.title]))



(s/def :telegram/InlineQueryResultVenue.type string?)
(s/def :telegram/InlineQueryResultVenue.id string?)
(s/def :telegram/InlineQueryResultVenue.latitude float?)
(s/def :telegram/InlineQueryResultVenue.longitude float?)
(s/def :telegram/InlineQueryResultVenue.title string?)
(s/def :telegram/InlineQueryResultVenue.address string?)
(s/def :telegram/InlineQueryResultVenue.foursquare_id string?)
(s/def :telegram/InlineQueryResultVenue.foursquare_type string?)
(s/def :telegram/InlineQueryResultVenue.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultVenue.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultVenue.thumb_url string?)
(s/def :telegram/InlineQueryResultVenue.thumb_width integer?)
(s/def :telegram/InlineQueryResultVenue.thumb_height integer?)
(s/def :telegram/InlineQueryResultVenue
  (s/keys :req-un [:telegram/InlineQueryResultVenue.foursquare_id
                   :telegram/InlineQueryResultVenue.foursquare_type
                   :telegram/InlineQueryResultVenue.reply_markup
                   :telegram/InlineQueryResultVenue.input_message_content
                   :telegram/InlineQueryResultVenue.thumb_url
                   :telegram/InlineQueryResultVenue.thumb_width
                   :telegram/InlineQueryResultVenue.thumb_height]
          :opt-un [:telegram/InlineQueryResultVenue.type
                   :telegram/InlineQueryResultVenue.id
                   :telegram/InlineQueryResultVenue.latitude
                   :telegram/InlineQueryResultVenue.longitude
                   :telegram/InlineQueryResultVenue.title
                   :telegram/InlineQueryResultVenue.address]))



(s/def :telegram/InlineQueryResultContact.type string?)
(s/def :telegram/InlineQueryResultContact.id string?)
(s/def :telegram/InlineQueryResultContact.phone_number string?)
(s/def :telegram/InlineQueryResultContact.first_name string?)
(s/def :telegram/InlineQueryResultContact.last_name string?)
(s/def :telegram/InlineQueryResultContact.vcard string?)
(s/def :telegram/InlineQueryResultContact.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultContact.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultContact.thumb_url string?)
(s/def :telegram/InlineQueryResultContact.thumb_width integer?)
(s/def :telegram/InlineQueryResultContact.thumb_height integer?)
(s/def :telegram/InlineQueryResultContact
  (s/keys :req-un [:telegram/InlineQueryResultContact.last_name
                   :telegram/InlineQueryResultContact.vcard
                   :telegram/InlineQueryResultContact.reply_markup
                   :telegram/InlineQueryResultContact.input_message_content
                   :telegram/InlineQueryResultContact.thumb_url
                   :telegram/InlineQueryResultContact.thumb_width
                   :telegram/InlineQueryResultContact.thumb_height]
          :opt-un [:telegram/InlineQueryResultContact.type
                   :telegram/InlineQueryResultContact.id
                   :telegram/InlineQueryResultContact.phone_number
                   :telegram/InlineQueryResultContact.first_name]))



(s/def :telegram/InlineQueryResultGame.type string?)
(s/def :telegram/InlineQueryResultGame.id string?)
(s/def :telegram/InlineQueryResultGame.game_short_name string?)
(s/def :telegram/InlineQueryResultGame.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultGame
  (s/keys :req-un [:telegram/InlineQueryResultGame.reply_markup]
          :opt-un [:telegram/InlineQueryResultGame.type
                   :telegram/InlineQueryResultGame.id
                   :telegram/InlineQueryResultGame.game_short_name]))



(s/def :telegram/InlineQueryResultCachedPhoto.type string?)
(s/def :telegram/InlineQueryResultCachedPhoto.id string?)
(s/def :telegram/InlineQueryResultCachedPhoto.photo_file_id string?)
(s/def :telegram/InlineQueryResultCachedPhoto.title string?)
(s/def :telegram/InlineQueryResultCachedPhoto.description string?)
(s/def :telegram/InlineQueryResultCachedPhoto.caption string?)
(s/def :telegram/InlineQueryResultCachedPhoto.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultCachedPhoto.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedPhoto.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedPhoto
  (s/keys :req-un [:telegram/InlineQueryResultCachedPhoto.title
                   :telegram/InlineQueryResultCachedPhoto.description
                   :telegram/InlineQueryResultCachedPhoto.caption
                   :telegram/InlineQueryResultCachedPhoto.parse_mode
                   :telegram/InlineQueryResultCachedPhoto.reply_markup
                   :telegram/InlineQueryResultCachedPhoto.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedPhoto.type
                   :telegram/InlineQueryResultCachedPhoto.id
                   :telegram/InlineQueryResultCachedPhoto.photo_file_id]))



(s/def :telegram/InlineQueryResultCachedGif.type string?)
(s/def :telegram/InlineQueryResultCachedGif.id string?)
(s/def :telegram/InlineQueryResultCachedGif.gif_file_id string?)
(s/def :telegram/InlineQueryResultCachedGif.title string?)
(s/def :telegram/InlineQueryResultCachedGif.caption string?)
(s/def :telegram/InlineQueryResultCachedGif.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultCachedGif.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedGif.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedGif
  (s/keys :req-un [:telegram/InlineQueryResultCachedGif.title
                   :telegram/InlineQueryResultCachedGif.caption
                   :telegram/InlineQueryResultCachedGif.parse_mode
                   :telegram/InlineQueryResultCachedGif.reply_markup
                   :telegram/InlineQueryResultCachedGif.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedGif.type
                   :telegram/InlineQueryResultCachedGif.id
                   :telegram/InlineQueryResultCachedGif.gif_file_id]))



(s/def :telegram/InlineQueryResultCachedMpeg4Gif.type string?)
(s/def :telegram/InlineQueryResultCachedMpeg4Gif.id string?)
(s/def :telegram/InlineQueryResultCachedMpeg4Gif.mpeg4_file_id string?)
(s/def :telegram/InlineQueryResultCachedMpeg4Gif.title string?)
(s/def :telegram/InlineQueryResultCachedMpeg4Gif.caption string?)
(s/def :telegram/InlineQueryResultCachedMpeg4Gif.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultCachedMpeg4Gif.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedMpeg4Gif.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedMpeg4Gif
  (s/keys :req-un [:telegram/InlineQueryResultCachedMpeg4Gif.title
                   :telegram/InlineQueryResultCachedMpeg4Gif.caption
                   :telegram/InlineQueryResultCachedMpeg4Gif.parse_mode
                   :telegram/InlineQueryResultCachedMpeg4Gif.reply_markup
                   :telegram/InlineQueryResultCachedMpeg4Gif.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedMpeg4Gif.type
                   :telegram/InlineQueryResultCachedMpeg4Gif.id
                   :telegram/InlineQueryResultCachedMpeg4Gif.mpeg4_file_id]))



(s/def :telegram/InlineQueryResultCachedSticker.type string?)
(s/def :telegram/InlineQueryResultCachedSticker.id string?)
(s/def :telegram/InlineQueryResultCachedSticker.sticker_file_id string?)
(s/def :telegram/InlineQueryResultCachedSticker.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedSticker.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedSticker
  (s/keys :req-un [:telegram/InlineQueryResultCachedSticker.reply_markup
                   :telegram/InlineQueryResultCachedSticker.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedSticker.type
                   :telegram/InlineQueryResultCachedSticker.id
                   :telegram/InlineQueryResultCachedSticker.sticker_file_id]))



(s/def :telegram/InlineQueryResultCachedDocument.type string?)
(s/def :telegram/InlineQueryResultCachedDocument.id string?)
(s/def :telegram/InlineQueryResultCachedDocument.title string?)
(s/def :telegram/InlineQueryResultCachedDocument.document_file_id string?)
(s/def :telegram/InlineQueryResultCachedDocument.description string?)
(s/def :telegram/InlineQueryResultCachedDocument.caption string?)
(s/def :telegram/InlineQueryResultCachedDocument.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultCachedDocument.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedDocument.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedDocument
  (s/keys :req-un [:telegram/InlineQueryResultCachedDocument.description
                   :telegram/InlineQueryResultCachedDocument.caption
                   :telegram/InlineQueryResultCachedDocument.parse_mode
                   :telegram/InlineQueryResultCachedDocument.reply_markup
                   :telegram/InlineQueryResultCachedDocument.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedDocument.type
                   :telegram/InlineQueryResultCachedDocument.id
                   :telegram/InlineQueryResultCachedDocument.title
                   :telegram/InlineQueryResultCachedDocument.document_file_id]))



(s/def :telegram/InlineQueryResultCachedVideo.type string?)
(s/def :telegram/InlineQueryResultCachedVideo.id string?)
(s/def :telegram/InlineQueryResultCachedVideo.video_file_id string?)
(s/def :telegram/InlineQueryResultCachedVideo.title string?)
(s/def :telegram/InlineQueryResultCachedVideo.description string?)
(s/def :telegram/InlineQueryResultCachedVideo.caption string?)
(s/def :telegram/InlineQueryResultCachedVideo.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultCachedVideo.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedVideo.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedVideo
  (s/keys :req-un [:telegram/InlineQueryResultCachedVideo.description
                   :telegram/InlineQueryResultCachedVideo.caption
                   :telegram/InlineQueryResultCachedVideo.parse_mode
                   :telegram/InlineQueryResultCachedVideo.reply_markup
                   :telegram/InlineQueryResultCachedVideo.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedVideo.type
                   :telegram/InlineQueryResultCachedVideo.id
                   :telegram/InlineQueryResultCachedVideo.video_file_id
                   :telegram/InlineQueryResultCachedVideo.title]))



(s/def :telegram/InlineQueryResultCachedVoice.type string?)
(s/def :telegram/InlineQueryResultCachedVoice.id string?)
(s/def :telegram/InlineQueryResultCachedVoice.voice_file_id string?)
(s/def :telegram/InlineQueryResultCachedVoice.title string?)
(s/def :telegram/InlineQueryResultCachedVoice.caption string?)
(s/def :telegram/InlineQueryResultCachedVoice.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultCachedVoice.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedVoice.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedVoice
  (s/keys :req-un [:telegram/InlineQueryResultCachedVoice.caption
                   :telegram/InlineQueryResultCachedVoice.parse_mode
                   :telegram/InlineQueryResultCachedVoice.reply_markup
                   :telegram/InlineQueryResultCachedVoice.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedVoice.type
                   :telegram/InlineQueryResultCachedVoice.id
                   :telegram/InlineQueryResultCachedVoice.voice_file_id
                   :telegram/InlineQueryResultCachedVoice.title]))



(s/def :telegram/InlineQueryResultCachedAudio.type string?)
(s/def :telegram/InlineQueryResultCachedAudio.id string?)
(s/def :telegram/InlineQueryResultCachedAudio.audio_file_id string?)
(s/def :telegram/InlineQueryResultCachedAudio.caption string?)
(s/def :telegram/InlineQueryResultCachedAudio.parse_mode #{"HTML" "Markdown"})
(s/def :telegram/InlineQueryResultCachedAudio.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/InlineQueryResultCachedAudio.input_message_content :telegram/InputMessageContent)
(s/def :telegram/InlineQueryResultCachedAudio
  (s/keys :req-un [:telegram/InlineQueryResultCachedAudio.caption
                   :telegram/InlineQueryResultCachedAudio.parse_mode
                   :telegram/InlineQueryResultCachedAudio.reply_markup
                   :telegram/InlineQueryResultCachedAudio.input_message_content]
          :opt-un [:telegram/InlineQueryResultCachedAudio.type
                   :telegram/InlineQueryResultCachedAudio.id
                   :telegram/InlineQueryResultCachedAudio.audio_file_id]))



(s/def :telegram/ChosenInlineResult.result_id string?)
(s/def :telegram/ChosenInlineResult.from :telegram/User)
(s/def :telegram/ChosenInlineResult.location :telegram/Location)
(s/def :telegram/ChosenInlineResult.inline_message_id string?)
(s/def :telegram/ChosenInlineResult.query string?)
(s/def :telegram/ChosenInlineResult
  (s/keys :req-un [:telegram/ChosenInlineResult.location
                   :telegram/ChosenInlineResult.inline_message_id]
          :opt-un [:telegram/ChosenInlineResult.result_id
                   :telegram/ChosenInlineResult.from
                   :telegram/ChosenInlineResult.query]))


(s/def InlineQueryResult
  (s/or
    :InlineQueryResultCachedAudio :telegram/InlineQueryResultCachedAudio
    :InlineQueryResultCachedDocument :telegram/InlineQueryResultCachedDocument
    :InlineQueryResultCachedGif :telegram/InlineQueryResultCachedGif
    :InlineQueryResultCachedMpeg4Gif :telegram/InlineQueryResultCachedMpeg4Gif
    :InlineQueryResultCachedPhoto :telegram/InlineQueryResultCachedPhoto
    :InlineQueryResultCachedSticker :telegram/InlineQueryResultCachedSticker
    :InlineQueryResultCachedVideo :telegram/InlineQueryResultCachedVideo
    :InlineQueryResultCachedVoice :telegram/InlineQueryResultCachedVoice
    :InlineQueryResultArticle :telegram/InlineQueryResultArticle
    :InlineQueryResultAudio :telegram/InlineQueryResultAudio
    :InlineQueryResultContact :telegram/InlineQueryResultContact
    :InlineQueryResultGame :telegram/InlineQueryResultGame
    :InlineQueryResultDocument :telegram/InlineQueryResultDocument
    :InlineQueryResultGif :telegram/InlineQueryResultGif
    :InlineQueryResultLocation :telegram/InlineQueryResultLocation
    :InlineQueryResultMpeg4Gif :telegram/InlineQueryResultMpeg4Gif
    :InlineQueryResultPhoto :telegram/InlineQueryResultPhoto
    :InlineQueryResultVenue :telegram/InlineQueryResultVenue
    :InlineQueryResultVideo :telegram/InlineQueryResultVideo
    :InlineQueryResultVoice :telegram/InlineQueryResultVoice))



(s/def :telegram/LabeledPrice.label string?)
(s/def :telegram/LabeledPrice.amount integer?)
(s/def :telegram/LabeledPrice
  (s/keys :opt-un [:telegram/LabeledPrice.label
                   :telegram/LabeledPrice.amount]))



(s/def :telegram/Invoice.title string?)
(s/def :telegram/Invoice.description string?)
(s/def :telegram/Invoice.start_parameter string?)
(s/def :telegram/Invoice.currency string?)
(s/def :telegram/Invoice.total_amount integer?)
(s/def :telegram/Invoice
  (s/keys
    :opt-un [:telegram/Invoice.title
             :telegram/Invoice.description
             :telegram/Invoice.start_parameter
             :telegram/Invoice.currency
             :telegram/Invoice.total_amount]))



(s/def :telegram/ShippingAddress.country_code string?)
(s/def :telegram/ShippingAddress.state string?)
(s/def :telegram/ShippingAddress.city string?)
(s/def :telegram/ShippingAddress.street_line1 string?)
(s/def :telegram/ShippingAddress.street_line2 string?)
(s/def :telegram/ShippingAddress.post_code string?)
(s/def :telegram/ShippingAddress
  (s/keys
    :opt-un [:telegram/ShippingAddress.country_code
             :telegram/ShippingAddress.state
             :telegram/ShippingAddress.city
             :telegram/ShippingAddress.street_line1
             :telegram/ShippingAddress.street_line2
             :telegram/ShippingAddress.post_code]))



(s/def :telegram/OrderInfo.name string?)
(s/def :telegram/OrderInfo.phone_number string?)
(s/def :telegram/OrderInfo.email string?)
(s/def :telegram/OrderInfo.shipping_address :telegram/ShippingAddress)
(s/def :telegram/OrderInfo
  (s/keys :req-un [:telegram/OrderInfo.name
                   :telegram/OrderInfo.phone_number
                   :telegram/OrderInfo.email
                   :telegram/OrderInfo.shipping_address]))



(s/def :telegram/ShippingOption.id string?)
(s/def :telegram/ShippingOption.title string?)
(s/def :telegram/ShippingOption.prices (s/coll-of :telegram/LabeledPrice))
(s/def :telegram/ShippingOption
  (s/keys :opt-un [:telegram/ShippingOption.id
                   :telegram/ShippingOption.title
                   :telegram/ShippingOption.prices]))



(s/def :telegram/SuccessfulPayment.currency string?)
(s/def :telegram/SuccessfulPayment.total_amount integer?)
(s/def :telegram/SuccessfulPayment.invoice_payload string?)
(s/def :telegram/SuccessfulPayment.shipping_option_id string?)
(s/def :telegram/SuccessfulPayment.order_info :telegram/OrderInfo)
(s/def :telegram/SuccessfulPayment.telegram_payment_charge_id string?)
(s/def :telegram/SuccessfulPayment.provider_payment_charge_id string?)
(s/def :telegram/SuccessfulPayment
  (s/keys :req-un [:telegram/SuccessfulPayment.shipping_option_id
                   :telegram/SuccessfulPayment.order_info]
          :opt-un [:telegram/SuccessfulPayment.currency
                   :telegram/SuccessfulPayment.total_amount
                   :telegram/SuccessfulPayment.invoice_payload
                   :telegram/SuccessfulPayment.telegram_payment_charge_id
                   :telegram/SuccessfulPayment.provider_payment_charge_id]))



(s/def :telegram/ShippingQuery.id string?)
(s/def :telegram/ShippingQuery.from :telegram/User)
(s/def :telegram/ShippingQuery.invoice_payload string?)
(s/def :telegram/ShippingQuery.shipping_address :telegram/ShippingAddress)
(s/def :telegram/ShippingQuery
  (s/keys
    :opt-un [:telegram/ShippingQuery.id
             :telegram/ShippingQuery.from
             :telegram/ShippingQuery.invoice_payload
             :telegram/ShippingQuery.shipping_address]))



(s/def :telegram/PreCheckoutQuery.id string?)
(s/def :telegram/PreCheckoutQuery.from :telegram/User)
(s/def :telegram/PreCheckoutQuery.currency string?)
(s/def :telegram/PreCheckoutQuery.total_amount integer?)
(s/def :telegram/PreCheckoutQuery.invoice_payload string?)
(s/def :telegram/PreCheckoutQuery.shipping_option_id string?)
(s/def :telegram/PreCheckoutQuery.order_info :telegram/OrderInfo)
(s/def :telegram/PreCheckoutQuery
  (s/keys :req-un [:telegram/PreCheckoutQuery.shipping_option_id
                   :telegram/PreCheckoutQuery.order_info]
          :opt-un [:telegram/PreCheckoutQuery.id
                   :telegram/PreCheckoutQuery.from
                   :telegram/PreCheckoutQuery.currency
                   :telegram/PreCheckoutQuery.total_amount
                   :telegram/PreCheckoutQuery.invoice_payload]))



(s/def :telegram/EncryptedCredentials.data string?)
(s/def :telegram/EncryptedCredentials.hash string?)
(s/def :telegram/EncryptedCredentials.secret string?)
(s/def :telegram/EncryptedCredentials
  (s/keys
    :opt-un [:telegram/EncryptedCredentials.data
             :telegram/EncryptedCredentials.hash
             :telegram/EncryptedCredentials.secret]))



(s/def :telegram/PassportData.data (s/coll-of :telegram/EncryptedPassportElement))
(s/def :telegram/PassportData.credentials :telegram/EncryptedCredentials)
(s/def :telegram/PassportData
  (s/keys :opt-un [:telegram/PassportData.data
                   :telegram/PassportData.credentials]))



(s/def :telegram/PassportFile.file_id string?)
(s/def :telegram/PassportFile.file_size integer?)
(s/def :telegram/PassportFile.file_date integer?)
(s/def :telegram/PassportFile
  (s/keys :opt-un [:telegram/PassportFile.file_id
                   :telegram/PassportFile.file_size
                   :telegram/PassportFile.file_date]))



(s/def :telegram/EncryptedPassportElement.type #{"personal_details" "passport" "driver_license" "identity_card" "internal_passport" "address" "utility_bill" "bank_statement" "rental_agreement" "passport_registration" "temporary_registration" "phone_number" "email"})
(s/def :telegram/EncryptedPassportElement.data string?)
(s/def :telegram/EncryptedPassportElement.phone_number string?)
(s/def :telegram/EncryptedPassportElement.email string?)
(s/def :telegram/EncryptedPassportElement.files (s/coll-of :telegram/PassportFile))
(s/def :telegram/EncryptedPassportElement.front_side :telegram/PassportFile)
(s/def :telegram/EncryptedPassportElement.reverse_side :telegram/PassportFile)
(s/def :telegram/EncryptedPassportElement.selfie :telegram/PassportFile)
(s/def :telegram/EncryptedPassportElement
  (s/keys :req-un [:telegram/EncryptedPassportElement.data
                   :telegram/EncryptedPassportElement.phone_number
                   :telegram/EncryptedPassportElement.email
                   :telegram/EncryptedPassportElement.files
                   :telegram/EncryptedPassportElement.front_side
                   :telegram/EncryptedPassportElement.reverse_side
                   :telegram/EncryptedPassportElement.selfie]
          :opt-un [:telegram/EncryptedPassportElement.type]))



(s/def :telegram/PassportElementError
  (s/or
    :PassportElementErrorDataField :telegram/PassportElementErrorDataField
    :PassportElementErrorFrontSide :telegram/PassportElementErrorFrontSide
    :PassportElementErrorReverseSide :telegram/PassportElementErrorReverseSide
    :PassportElementErrorSelfie :telegram/PassportElementErrorSelfie
    :PassportElementErrorFile :telegram/PassportElementErrorFile
    :PassportElementErrorFiles :telegram/PassportElementErrorFiles))



(s/def :telegram/PassportElementErrorDataField.source string?)
(s/def :telegram/PassportElementErrorDataField.type #{"personal_details" "passport" "driver_license" "identity_card" "internal_passport" "address"})
(s/def :telegram/PassportElementErrorDataField.field_name string?)
(s/def :telegram/PassportElementErrorDataField.data_hash string?)
(s/def :telegram/PassportElementErrorDataField.message string?)
(s/def :telegram/PassportElementErrorDataField
  (s/keys
    :opt-un [:telegram/PassportElementErrorDataField.source
             :telegram/PassportElementErrorDataField.type
             :telegram/PassportElementErrorDataField.field_name
             :telegram/PassportElementErrorDataField.data_hash
             :telegram/PassportElementErrorDataField.message]))



(s/def :telegram/PassportElementErrorFrontSide.source string?)
(s/def :telegram/PassportElementErrorFrontSide.type #{"passport" "driver_license" "identity_card" "internal_passport"})
(s/def :telegram/PassportElementErrorFrontSide.file_hash string?)
(s/def :telegram/PassportElementErrorFrontSide.message string?)
(s/def :telegram/PassportElementErrorFrontSide
  (s/keys
    :opt-un [:telegram/PassportElementErrorFrontSide.source
             :telegram/PassportElementErrorFrontSide.type
             :telegram/PassportElementErrorFrontSide.file_hash
             :telegram/PassportElementErrorFrontSide.message]))



(s/def :telegram/PassportElementErrorReverseSide.source string?)
(s/def :telegram/PassportElementErrorReverseSide.type #{"driver_license" "identity_card"})
(s/def :telegram/PassportElementErrorReverseSide.file_hash string?)
(s/def :telegram/PassportElementErrorReverseSide.message string?)
(s/def :telegram/PassportElementErrorReverseSide
  (s/keys
    :opt-un [:telegram/PassportElementErrorReverseSide.source
             :telegram/PassportElementErrorReverseSide.type
             :telegram/PassportElementErrorReverseSide.file_hash
             :telegram/PassportElementErrorReverseSide.message]))



(s/def :telegram/PassportElementErrorSelfie.source string?)
(s/def :telegram/PassportElementErrorSelfie.type #{"passport" "driver_license" "identity_card" "internal_passport"})
(s/def :telegram/PassportElementErrorSelfie.file_hash string?)
(s/def :telegram/PassportElementErrorSelfie.message string?)
(s/def :telegram/PassportElementErrorSelfie
  (s/keys
    :opt-un [:telegram/PassportElementErrorSelfie.source
             :telegram/PassportElementErrorSelfie.type
             :telegram/PassportElementErrorSelfie.file_hash
             :telegram/PassportElementErrorSelfie.message]))



(s/def :telegram/PassportElementErrorFile.source string?)
(s/def :telegram/PassportElementErrorFile.type #{"utility_bill" "bank_statement" "rental_agreement" "passport_registration" "temporary_registration"})
(s/def :telegram/PassportElementErrorFile.file_hash string?)
(s/def :telegram/PassportElementErrorFile.message string?)
(s/def :telegram/PassportElementErrorFile
  (s/keys
    :opt-un [:telegram/PassportElementErrorFile.source
             :telegram/PassportElementErrorFile.type
             :telegram/PassportElementErrorFile.file_hash
             :telegram/PassportElementErrorFile.message]))



(s/def :telegram/PassportElementErrorFiles.source string?)
(s/def :telegram/PassportElementErrorFiles.type #{"utility_bill" "bank_statement" "rental_agreement" "passport_registration" "temporary_registration"})
(s/def :telegram/PassportElementErrorFiles.file_hashes (s/coll-of string?))
(s/def :telegram/PassportElementErrorFiles.message string?)
(s/def :telegram/PassportElementErrorFiles
  (s/keys
    :opt-un [:telegram/PassportElementErrorFiles.source
             :telegram/PassportElementErrorFiles.type
             :telegram/PassportElementErrorFiles.file_hashes
             :telegram/PassportElementErrorFiles.message]))



(s/def :telegram/Game.title string?)
(s/def :telegram/Game.description string?)
(s/def :telegram/Game.photo (s/coll-of :telegram/PhotoSize))
(s/def :telegram/Game.text string?)
(s/def :telegram/Game.text_entities (s/coll-of :telegram/MessageEntity))
(s/def :telegram/Game.animation :telegram/Animation)
(s/def :telegram/Game
  (s/keys :req-un [:telegram/Game.text
                   :telegram/Game.text_entities
                   :telegram/Game.animation]
          :opt-un [:telegram/Game.title
                   :telegram/Game.description
                   :telegram/Game.photo]))



(s/def :telegram/GameHighScore.position integer?)
(s/def :telegram/GameHighScore.user :telegram/User)
(s/def :telegram/GameHighScore.score integer?)
(s/def :telegram/GameHighScore
  (s/keys :opt-un [:telegram/GameHighScore.position
                   :telegram/GameHighScore.user
                   :telegram/GameHighScore.score]))



(s/def :telegram/Message.message_id integer?)
(s/def :telegram/Message.from :telegram/User)
(s/def :telegram/Message.date integer?)
(s/def :telegram/Message.chat :telegram/Chat)
(s/def :telegram/Message.forward_from :telegram/User)
(s/def :telegram/Message.forward_from_chat :telegram/Chat)
(s/def :telegram/Message.forward_from_message_id integer?)
(s/def :telegram/Message.forward_signature string?)
(s/def :telegram/Message.forward_date integer?)
(s/def :telegram/Message.reply_to_message :telegram/Message)
(s/def :telegram/Message.edit_date integer?)
(s/def :telegram/Message.media_group_id string?)
(s/def :telegram/Message.author_signature string?)
(s/def :telegram/Message.text string?)
(s/def :telegram/Message.entities (s/coll-of :telegram/MessageEntity))
(s/def :telegram/Message.caption_entities (s/coll-of :telegram/MessageEntity))
(s/def :telegram/Message.audio :telegram/Audio)
(s/def :telegram/Message.document :telegram/Document)
(s/def :telegram/Message.animation :telegram/Animation)
(s/def :telegram/Message.game :telegram/Game)
(s/def :telegram/Message.photo (s/coll-of :telegram/PhotoSize))
(s/def :telegram/Message.sticker :telegram/Sticker)
(s/def :telegram/Message.video :telegram/Video)
(s/def :telegram/Message.voice :telegram/Voice)
(s/def :telegram/Message.video_note :telegram/VideoNote)
(s/def :telegram/Message.caption string?)
(s/def :telegram/Message.contact :telegram/Contact)
(s/def :telegram/Message.location :telegram/Location)
(s/def :telegram/Message.venue :telegram/Venue)
(s/def :telegram/Message.new_chat_members (s/coll-of :telegram/User))
(s/def :telegram/Message.left_chat_member :telegram/User)
(s/def :telegram/Message.new_chat_title string?)
(s/def :telegram/Message.new_chat_photo (s/coll-of :telegram/PhotoSize))
(s/def :telegram/Message.delete_chat_photo #{true})
(s/def :telegram/Message.group_chat_created #{true})
(s/def :telegram/Message.supergroup_chat_created #{true})
(s/def :telegram/Message.channel_chat_created #{true})
(s/def :telegram/Message.migrate_to_chat_id integer?)
(s/def :telegram/Message.migrate_from_chat_id integer?)
(s/def :telegram/Message.pinned_message :telegram/Message)
(s/def :telegram/Message.invoice :telegram/Invoice)
(s/def :telegram/Message.successful_payment :telegram/SuccessfulPayment)
(s/def :telegram/Message.connected_website string?)
(s/def :telegram/Message.passport_data :telegram/PassportData)
(s/def :telegram/Message
  (s/keys :req-un [:telegram/Message.from
                   :telegram/Message.forward_from
                   :telegram/Message.forward_from_chat
                   :telegram/Message.forward_from_message_id
                   :telegram/Message.forward_signature
                   :telegram/Message.forward_date
                   :telegram/Message.reply_to_message
                   :telegram/Message.edit_date
                   :telegram/Message.media_group_id
                   :telegram/Message.author_signature
                   :telegram/Message.text
                   :telegram/Message.entities
                   :telegram/Message.caption_entities
                   :telegram/Message.audio
                   :telegram/Message.document
                   :telegram/Message.animation
                   :telegram/Message.game
                   :telegram/Message.photo
                   :telegram/Message.sticker
                   :telegram/Message.video
                   :telegram/Message.voice
                   :telegram/Message.video_note
                   :telegram/Message.caption
                   :telegram/Message.contact
                   :telegram/Message.location
                   :telegram/Message.venue
                   :telegram/Message.new_chat_members
                   :telegram/Message.left_chat_member
                   :telegram/Message.new_chat_title
                   :telegram/Message.new_chat_photo
                   :telegram/Message.delete_chat_photo
                   :telegram/Message.group_chat_created
                   :telegram/Message.supergroup_chat_created
                   :telegram/Message.channel_chat_created
                   :telegram/Message.migrate_to_chat_id
                   :telegram/Message.migrate_from_chat_id
                   :telegram/Message.pinned_message
                   :telegram/Message.invoice
                   :telegram/Message.successful_payment
                   :telegram/Message.connected_website
                   :telegram/Message.passport_data]
          :opt-un [:telegram/Message.message_id
                   :telegram/Message.date
                   :telegram/Message.chat]))



(s/def :telegram/Chat.id integer?)
(s/def :telegram/Chat.type #{"private" "group" "supergroup" "channel"})
(s/def :telegram/Chat.title string?)
(s/def :telegram/Chat.username string?)
(s/def :telegram/Chat.first_name string?)
(s/def :telegram/Chat.last_name string?)
(s/def :telegram/Chat.all_members_are_administrators boolean?)
(s/def :telegram/Chat.photo :telegram/ChatPhoto)
(s/def :telegram/Chat.description string?)
(s/def :telegram/Chat.invite_link string?)
(s/def :telegram/Chat.pinned_message :telegram/Message)
(s/def :telegram/Chat.sticker_set_name string?)
(s/def :telegram/Chat.can_set_sticker_set boolean?)
(s/def :telegram/Chat
  (s/keys :req-un [:telegram/Chat.title
                   :telegram/Chat.username
                   :telegram/Chat.first_name
                   :telegram/Chat.last_name
                   :telegram/Chat.all_members_are_administrators
                   :telegram/Chat.photo
                   :telegram/Chat.description
                   :telegram/Chat.invite_link
                   :telegram/Chat.pinned_message
                   :telegram/Chat.sticker_set_name
                   :telegram/Chat.can_set_sticker_set]
          :opt-un [:telegram/Chat.id
                   :telegram/Chat.type]))



(s/def :telegram/Update.update_id integer?)
(s/def :telegram/Update.message :telegram/Message)
(s/def :telegram/Update.edited_message :telegram/Message)
(s/def :telegram/Update.channel_post :telegram/Message)
(s/def :telegram/Update.edited_channel_post :telegram/Message)
(s/def :telegram/Update.inline_query :telegram/InlineQuery)
(s/def :telegram/Update.chosen_inline_result :telegram/ChosenInlineResult)
(s/def :telegram/Update.callback_query :telegram/CallbackQuery)
(s/def :telegram/Update.shipping_query :telegram/ShippingQuery)
(s/def :telegram/Update.pre_checkout_query :telegram/PreCheckoutQuery)
(s/def :telegram/Update
  (s/keys :req-un [:telegram/Update.message
                   :telegram/Update.edited_message
                   :telegram/Update.channel_post
                   :telegram/Update.edited_channel_post
                   :telegram/Update.inline_query
                   :telegram/Update.chosen_inline_result
                   :telegram/Update.callback_query
                   :telegram/Update.shipping_query
                   :telegram/Update.pre_checkout_query]
          :opt-un [:telegram/Update.update_id]))



;; methods



(s/def :telegram/getUpdates.offset integer?)
(s/def :telegram/getUpdates.limit integer?)
(s/def :telegram/getUpdates.timeout integer?)
(s/def :telegram/getUpdates.allowed_updates (s/coll-of string?))
(s/def :telegram/getUpdatesParams
  (s/keys
    :opt-un [:telegram/getUpdates.offset
             :telegram/getUpdates.limit
             :telegram/getUpdates.timeout
             :telegram/getUpdates.allowed_updates]))
(s/fdef api/get-updates
  :args (s/cat :token string?
               :params :telegram/getUpdatesParams))



(s/def :telegram/setWebhook.url string?)
(s/def :telegram/setWebhook.certificate :telegram/InputFile)
(s/def :telegram/setWebhook.max_connections integer?)
(s/def :telegram/setWebhook.allowed_updates (s/coll-of string?))
(s/def :telegram/setWebhookParams
  (s/keys
    :req-un [:telegram/setWebhook.url]
    :opt-un [:telegram/setWebhook.certificate :telegram/setWebhook.max_connections :telegram/setWebhook.allowed_updates]))
(s/fdef api/set-webhook
  :args (s/cat :token string?
               :params :telegram/setWebhookParams))



(s/def :telegram/deleteWebhookParams any?)
(s/fdef api/delete-webhook
  :args (s/cat :token string?
               :params :telegram/deleteWebhookParams))



(s/def :telegram/getWebhookInfoParams any?)
(s/fdef api/get-webhook-info
  :args (s/cat :token string?
               :params :telegram/getWebhookInfoParams))



(s/def :telegram/getMeParams any?)
(s/fdef api/get-me
  :args (s/cat :token string?
               :params :telegram/getMeParams))



(s/def :telegram/sendMessage.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendMessage.text string?)
(s/def :telegram/sendMessage.parse_mode string?)
(s/def :telegram/sendMessage.disable_web_page_preview boolean?)
(s/def :telegram/sendMessage.disable_notification boolean?)
(s/def :telegram/sendMessage.reply_to_message_id integer?)
(s/def :telegram/sendMessage.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendMessageParams
  (s/keys
    :req-un [:telegram/sendMessage.chat_id
             :telegram/sendMessage.text]
    :opt-un [:telegram/sendMessage.parse_mode
             :telegram/sendMessage.disable_web_page_preview
             :telegram/sendMessage.disable_notification
             :telegram/sendMessage.reply_to_message_id
             :telegram/sendMessage.reply_markup]))
(s/fdef api/send-message
  :args (s/cat :token string?
               :params :telegram/sendMessageParams))



(s/def :telegram/forwardMessage.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/forwardMessage.from_chat_id (s/or :string string? :integer integer?))
(s/def :telegram/forwardMessage.disable_notification boolean?)
(s/def :telegram/forwardMessage.message_id integer?)
(s/def :telegram/forwardMessageParams
  (s/keys
    :req-un [:telegram/forwardMessage.chat_id :telegram/forwardMessage.from_chat_id :telegram/forwardMessage.message_id]
    :opt-un [:telegram/forwardMessage.disable_notification]))
(s/fdef api/forward-message
  :args (s/cat :token string?
               :params :telegram/forwardMessageParams))



(s/def :telegram/sendPhoto.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendPhoto.photo (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendPhoto.caption string?)
(s/def :telegram/sendPhoto.parse_mode string?)
(s/def :telegram/sendPhoto.disable_notification boolean?)
(s/def :telegram/sendPhoto.reply_to_message_id integer?)
(s/def :telegram/sendPhoto.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendPhotoParams
  (s/keys
    :req-un [:telegram/sendPhoto.chat_id :telegram/sendPhoto.photo]
    :opt-un [:telegram/sendPhoto.caption
             :telegram/sendPhoto.parse_mode
             :telegram/sendPhoto.disable_notification
             :telegram/sendPhoto.reply_to_message_id
             :telegram/sendPhoto.reply_markup]))
(s/fdef api/send-photo
  :args (s/cat :token string?
               :params :telegram/sendPhotoParams))



(s/def :telegram/sendAudio.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendAudio.audio (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendAudio.caption string?)
(s/def :telegram/sendAudio.parse_mode string?)
(s/def :telegram/sendAudio.duration integer?)
(s/def :telegram/sendAudio.performer string?)
(s/def :telegram/sendAudio.title string?)
(s/def :telegram/sendAudio.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendAudio.disable_notification boolean?)
(s/def :telegram/sendAudio.reply_to_message_id integer?)
(s/def :telegram/sendAudio.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendAudioParams
  (s/keys
    :req-un [:telegram/sendAudio.chat_id :telegram/sendAudio.audio]
    :opt-un [:telegram/sendAudio.caption
             :telegram/sendAudio.parse_mode
             :telegram/sendAudio.duration
             :telegram/sendAudio.performer
             :telegram/sendAudio.title
             :telegram/sendAudio.thumb
             :telegram/sendAudio.disable_notification
             :telegram/sendAudio.reply_to_message_id
             :telegram/sendAudio.reply_markup]))
(s/fdef api/send-audio
  :args (s/cat :token string?
               :params :telegram/sendAudioParams))



(s/def :telegram/sendDocument.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendDocument.document (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendDocument.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendDocument.caption string?)
(s/def :telegram/sendDocument.parse_mode string?)
(s/def :telegram/sendDocument.disable_notification boolean?)
(s/def :telegram/sendDocument.reply_to_message_id integer?)
(s/def :telegram/sendDocument.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendDocumentParams
  (s/keys
    :req-un [:telegram/sendDocument.chat_id :telegram/sendDocument.document]
    :opt-un [:telegram/sendDocument.thumb
             :telegram/sendDocument.caption
             :telegram/sendDocument.parse_mode
             :telegram/sendDocument.disable_notification
             :telegram/sendDocument.reply_to_message_id
             :telegram/sendDocument.reply_markup]))
(s/fdef api/send-document
  :args (s/cat :token string?
               :params :telegram/sendDocumentParams))



(s/def :telegram/sendVideo.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendVideo.video (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendVideo.duration integer?)
(s/def :telegram/sendVideo.width integer?)
(s/def :telegram/sendVideo.height integer?)
(s/def :telegram/sendVideo.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendVideo.caption string?)
(s/def :telegram/sendVideo.parse_mode string?)
(s/def :telegram/sendVideo.supports_streaming boolean?)
(s/def :telegram/sendVideo.disable_notification boolean?)
(s/def :telegram/sendVideo.reply_to_message_id integer?)
(s/def :telegram/sendVideo.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendVideoParams
  (s/keys
    :req-un [:telegram/sendVideo.chat_id :telegram/sendVideo.video]
    :opt-un [:telegram/sendVideo.duration
             :telegram/sendVideo.width
             :telegram/sendVideo.height
             :telegram/sendVideo.thumb
             :telegram/sendVideo.caption
             :telegram/sendVideo.parse_mode
             :telegram/sendVideo.supports_streaming
             :telegram/sendVideo.disable_notification
             :telegram/sendVideo.reply_to_message_id
             :telegram/sendVideo.reply_markup]))
(s/fdef api/send-video
  :args (s/cat :token string?
               :params :telegram/sendVideoParams))



(s/def :telegram/sendAnimation.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendAnimation.animation (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendAnimation.duration integer?)
(s/def :telegram/sendAnimation.width integer?)
(s/def :telegram/sendAnimation.height integer?)
(s/def :telegram/sendAnimation.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendAnimation.caption string?)
(s/def :telegram/sendAnimation.parse_mode string?)
(s/def :telegram/sendAnimation.disable_notification boolean?)
(s/def :telegram/sendAnimation.reply_to_message_id integer?)
(s/def :telegram/sendAnimation.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendAnimationParams
  (s/keys
    :req-un [:telegram/sendAnimation.chat_id :telegram/sendAnimation.animation]
    :opt-un [:telegram/sendAnimation.duration
             :telegram/sendAnimation.width
             :telegram/sendAnimation.height
             :telegram/sendAnimation.thumb
             :telegram/sendAnimation.caption
             :telegram/sendAnimation.parse_mode
             :telegram/sendAnimation.disable_notification
             :telegram/sendAnimation.reply_to_message_id
             :telegram/sendAnimation.reply_markup]))
(s/fdef api/send-animation
  :args (s/cat :token string?
               :params :telegram/sendAnimationParams))



(s/def :telegram/sendVoice.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendVoice.voice (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendVoice.caption string?)
(s/def :telegram/sendVoice.parse_mode string?)
(s/def :telegram/sendVoice.duration integer?)
(s/def :telegram/sendVoice.disable_notification boolean?)
(s/def :telegram/sendVoice.reply_to_message_id integer?)
(s/def :telegram/sendVoice.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendVoiceParams
  (s/keys
    :req-un [:telegram/sendVoice.chat_id :telegram/sendVoice.voice]
    :opt-un [:telegram/sendVoice.caption
             :telegram/sendVoice.parse_mode
             :telegram/sendVoice.duration
             :telegram/sendVoice.disable_notification
             :telegram/sendVoice.reply_to_message_id
             :telegram/sendVoice.reply_markup]))
(s/fdef api/send-voice
  :args (s/cat :token string?
               :params :telegram/sendVoiceParams))



(s/def :telegram/sendVideoNote.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendVideoNote.video_note (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendVideoNote.duration integer?)
(s/def :telegram/sendVideoNote.length integer?)
(s/def :telegram/sendVideoNote.thumb (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendVideoNote.disable_notification boolean?)
(s/def :telegram/sendVideoNote.reply_to_message_id integer?)
(s/def :telegram/sendVideoNote.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendVideoNoteParams
  (s/keys
    :req-un [:telegram/sendVideoNote.chat_id :telegram/sendVideoNote.video_note]
    :opt-un [:telegram/sendVideoNote.duration
             :telegram/sendVideoNote.length
             :telegram/sendVideoNote.thumb
             :telegram/sendVideoNote.disable_notification
             :telegram/sendVideoNote.reply_to_message_id
             :telegram/sendVideoNote.reply_markup]))
(s/fdef api/send-video-note
  :args (s/cat :token string?
               :params :telegram/sendVideoNoteParams))



(s/def :telegram/sendMediaGroup.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendMediaGroup.media (s/coll-of (s/or :InputMediaPhoto :telegram/InputMediaPhoto
                                                       :InputMediaVideo :telegram/InputMediaVideo)))
(s/def :telegram/sendMediaGroup.disable_notification boolean?)
(s/def :telegram/sendMediaGroup.reply_to_message_id integer?)
(s/def :telegram/sendMediaGroupParams
  (s/keys
    :req-un [:telegram/sendMediaGroup.chat_id :telegram/sendMediaGroup.media]
    :opt-un [:telegram/sendMediaGroup.disable_notification :telegram/sendMediaGroup.reply_to_message_id]))
(s/fdef api/send-media-group
  :args (s/cat :token string?
               :params :telegram/sendMediaGroupParams))



(s/def :telegram/sendLocation.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendLocation.latitude float?)
(s/def :telegram/sendLocation.longitude float?)
(s/def :telegram/sendLocation.live_period integer?)
(s/def :telegram/sendLocation.disable_notification boolean?)
(s/def :telegram/sendLocation.reply_to_message_id integer?)
(s/def :telegram/sendLocation.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendLocationParams
  (s/keys
    :req-un [:telegram/sendLocation.chat_id :telegram/sendLocation.latitude :telegram/sendLocation.longitude]
    :opt-un [:telegram/sendLocation.live_period
             :telegram/sendLocation.disable_notification
             :telegram/sendLocation.reply_to_message_id
             :telegram/sendLocation.reply_markup]))
(s/fdef api/send-location
  :args (s/cat :token string?
               :params :telegram/sendLocationParams))



(s/def :telegram/editMessageLiveLocation.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/editMessageLiveLocation.message_id integer?)
(s/def :telegram/editMessageLiveLocation.inline_message_id string?)
(s/def :telegram/editMessageLiveLocation.latitude float?)
(s/def :telegram/editMessageLiveLocation.longitude float?)
(s/def :telegram/editMessageLiveLocation.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/editMessageLiveLocationParams
  (s/keys
    :req-un [:telegram/editMessageLiveLocation.latitude :telegram/editMessageLiveLocation.longitude]
    :opt-un [:telegram/editMessageLiveLocation.chat_id
             :telegram/editMessageLiveLocation.message_id
             :telegram/editMessageLiveLocation.inline_message_id
             :telegram/editMessageLiveLocation.reply_markup]))
(s/fdef api/edit-message-live-location
  :args (s/cat :token string?
               :params :telegram/editMessageLiveLocationParams))



(s/def :telegram/stopMessageLiveLocation.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/stopMessageLiveLocation.message_id integer?)
(s/def :telegram/stopMessageLiveLocation.inline_message_id string?)
(s/def :telegram/stopMessageLiveLocation.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/stopMessageLiveLocationParams
  (s/keys
    :opt-un [:telegram/stopMessageLiveLocation.chat_id
             :telegram/stopMessageLiveLocation.message_id
             :telegram/stopMessageLiveLocation.inline_message_id
             :telegram/stopMessageLiveLocation.reply_markup]))
(s/fdef api/stop-message-live-location
  :args (s/cat :token string?
               :params :telegram/stopMessageLiveLocationParams))



(s/def :telegram/sendVenue.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendVenue.latitude float?)
(s/def :telegram/sendVenue.longitude float?)
(s/def :telegram/sendVenue.title string?)
(s/def :telegram/sendVenue.address string?)
(s/def :telegram/sendVenue.foursquare_id string?)
(s/def :telegram/sendVenue.foursquare_type string?)
(s/def :telegram/sendVenue.disable_notification boolean?)
(s/def :telegram/sendVenue.reply_to_message_id integer?)
(s/def :telegram/sendVenue.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendVenueParams
  (s/keys
    :req-un [:telegram/sendVenue.chat_id
             :telegram/sendVenue.latitude
             :telegram/sendVenue.longitude
             :telegram/sendVenue.title
             :telegram/sendVenue.address]
    :opt-un [:telegram/sendVenue.foursquare_id
             :telegram/sendVenue.foursquare_type
             :telegram/sendVenue.disable_notification
             :telegram/sendVenue.reply_to_message_id
             :telegram/sendVenue.reply_markup]))
(s/fdef api/send-venue
  :args (s/cat :token string?
               :params :telegram/sendVenueParams))



(s/def :telegram/sendContact.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendContact.phone_number string?)
(s/def :telegram/sendContact.first_name string?)
(s/def :telegram/sendContact.last_name string?)
(s/def :telegram/sendContact.vcard string?)
(s/def :telegram/sendContact.disable_notification boolean?)
(s/def :telegram/sendContact.reply_to_message_id integer?)
(s/def :telegram/sendContact.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendContactParams
  (s/keys
    :req-un [:telegram/sendContact.chat_id :telegram/sendContact.phone_number :telegram/sendContact.first_name]
    :opt-un [:telegram/sendContact.last_name
             :telegram/sendContact.vcard
             :telegram/sendContact.disable_notification
             :telegram/sendContact.reply_to_message_id
             :telegram/sendContact.reply_markup]))
(s/fdef api/send-contact
  :args (s/cat :token string?
               :params :telegram/sendContactParams))



(s/def :telegram/sendChatAction.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendChatAction.action string?)
(s/def :telegram/sendChatActionParams
  (s/keys :req-un [:telegram/sendChatAction.chat_id :telegram/sendChatAction.action]))
(s/fdef api/send-chat-action
  :args (s/cat :token string?
               :params :telegram/sendChatActionParams))



(s/def :telegram/getUserProfilePhotos.user_id integer?)
(s/def :telegram/getUserProfilePhotos.offset integer?)
(s/def :telegram/getUserProfilePhotos.limit integer?)
(s/def :telegram/getUserProfilePhotosParams
  (s/keys
    :req-un [:telegram/getUserProfilePhotos.user_id]
    :opt-un [:telegram/getUserProfilePhotos.offset :telegram/getUserProfilePhotos.limit]))
(s/fdef api/get-user-profile-photos
  :args (s/cat :token string?
               :params :telegram/getUserProfilePhotosParams))



(s/def :telegram/getFile.file_id string?)
(s/def :telegram/getFileParams (s/keys :req-un [:telegram/getFile.file_id]))
(s/fdef api/get-file
  :args (s/cat :token string?
               :params :telegram/getFileParams))



(s/def :telegram/kickChatMember.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/kickChatMember.user_id integer?)
(s/def :telegram/kickChatMember.until_date integer?)
(s/def :telegram/kickChatMemberParams
  (s/keys
    :req-un [:telegram/kickChatMember.chat_id :telegram/kickChatMember.user_id]
    :opt-un [:telegram/kickChatMember.until_date]))
(s/fdef api/kick-chat-member
  :args (s/cat :token string?
               :params :telegram/kickChatMemberParams))



(s/def :telegram/unbanChatMember.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/unbanChatMember.user_id integer?)
(s/def :telegram/unbanChatMemberParams
  (s/keys :req-un [:telegram/unbanChatMember.chat_id :telegram/unbanChatMember.user_id]))
(s/fdef api/unban-chat-member
  :args (s/cat :token string?
               :params :telegram/unbanChatMemberParams))



(s/def :telegram/restrictChatMember.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/restrictChatMember.user_id integer?)
(s/def :telegram/restrictChatMember.until_date integer?)
(s/def :telegram/restrictChatMember.can_send_messages boolean?)
(s/def :telegram/restrictChatMember.can_send_media_messages boolean?)
(s/def :telegram/restrictChatMember.can_send_other_messages boolean?)
(s/def :telegram/restrictChatMember.can_add_web_page_previews boolean?)
(s/def :telegram/restrictChatMemberParams
  (s/keys
    :req-un [:telegram/restrictChatMember.chat_id :telegram/restrictChatMember.user_id]
    :opt-un [:telegram/restrictChatMember.until_date
             :telegram/restrictChatMember.can_send_messages
             :telegram/restrictChatMember.can_send_media_messages
             :telegram/restrictChatMember.can_send_other_messages
             :telegram/restrictChatMember.can_add_web_page_previews]))
(s/fdef api/restrict-chat-member
  :args (s/cat :token string?
               :params :telegram/restrictChatMemberParams))



(s/def :telegram/promoteChatMember.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/promoteChatMember.user_id integer?)
(s/def :telegram/promoteChatMember.can_change_info boolean?)
(s/def :telegram/promoteChatMember.can_post_messages boolean?)
(s/def :telegram/promoteChatMember.can_edit_messages boolean?)
(s/def :telegram/promoteChatMember.can_delete_messages boolean?)
(s/def :telegram/promoteChatMember.can_invite_users boolean?)
(s/def :telegram/promoteChatMember.can_restrict_members boolean?)
(s/def :telegram/promoteChatMember.can_pin_messages boolean?)
(s/def :telegram/promoteChatMember.can_promote_members boolean?)
(s/def :telegram/promoteChatMemberParams
  (s/keys
    :req-un [:telegram/promoteChatMember.chat_id :telegram/promoteChatMember.user_id]
    :opt-un [:telegram/promoteChatMember.can_change_info
             :telegram/promoteChatMember.can_post_messages
             :telegram/promoteChatMember.can_edit_messages
             :telegram/promoteChatMember.can_delete_messages
             :telegram/promoteChatMember.can_invite_users
             :telegram/promoteChatMember.can_restrict_members
             :telegram/promoteChatMember.can_pin_messages
             :telegram/promoteChatMember.can_promote_members]))
(s/fdef api/promote-chat-member
  :args (s/cat :token string?
               :params :telegram/promoteChatMemberParams))



(s/def :telegram/exportChatInviteLink.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/exportChatInviteLinkParams (s/keys :req-un [:telegram/exportChatInviteLink.chat_id]))
(s/fdef api/export-chat-invite-link
  :args (s/cat :token string?
               :params :telegram/exportChatInviteLinkParams))



(s/def :telegram/setChatPhoto.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/setChatPhoto.photo :telegram/InputFile)
(s/def :telegram/setChatPhotoParams (s/keys :req-un [:telegram/setChatPhoto.chat_id :telegram/setChatPhoto.photo]))
(s/fdef api/set-chat-photo
  :args (s/cat :token string?
               :params :telegram/setChatPhotoParams))



(s/def :telegram/deleteChatPhoto.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/deleteChatPhotoParams (s/keys :req-un [:telegram/deleteChatPhoto.chat_id]))
(s/fdef api/delete-chat-photo
  :args (s/cat :token string?
               :params :telegram/deleteChatPhotoParams))



(s/def :telegram/setChatTitle.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/setChatTitle.title string?)
(s/def :telegram/setChatTitleParams (s/keys :req-un [:telegram/setChatTitle.chat_id :telegram/setChatTitle.title]))
(s/fdef api/set-chat-title
  :args (s/cat :token string?
               :params :telegram/setChatTitleParams))



(s/def :telegram/setChatDescription.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/setChatDescription.description string?)
(s/def :telegram/setChatDescriptionParams
  (s/keys :req-un [:telegram/setChatDescription.chat_id] :opt-un [:telegram/setChatDescription.description]))
(s/fdef api/set-chat-description
  :args (s/cat :token string?
               :params :telegram/setChatDescriptionParams))



(s/def :telegram/pinChatMessage.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/pinChatMessage.message_id integer?)
(s/def :telegram/pinChatMessage.disable_notification boolean?)
(s/def :telegram/pinChatMessageParams
  (s/keys
    :req-un [:telegram/pinChatMessage.chat_id :telegram/pinChatMessage.message_id]
    :opt-un [:telegram/pinChatMessage.disable_notification]))
(s/fdef api/pin-chat-message
  :args (s/cat :token string?
               :params :telegram/pinChatMessageParams))



(s/def :telegram/unpinChatMessage.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/unpinChatMessageParams (s/keys :req-un [:telegram/unpinChatMessage.chat_id]))
(s/fdef api/unpin-chat-message
  :args (s/cat :token string?
               :params :telegram/unpinChatMessageParams))



(s/def :telegram/leaveChat.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/leaveChatParams (s/keys :req-un [:telegram/leaveChat.chat_id]))
(s/fdef api/leave-chat
  :args (s/cat :token string?
               :params :telegram/leaveChatParams))



(s/def :telegram/getChat.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/getChatParams (s/keys :req-un [:telegram/getChat.chat_id]))
(s/fdef api/get-chat
  :args (s/cat :token string?
               :params :telegram/getChatParams))



(s/def :telegram/getChatAdministrators.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/getChatAdministratorsParams (s/keys :req-un [:telegram/getChatAdministrators.chat_id]))
(s/fdef api/get-chat-administrators
  :args (s/cat :token string?
               :params :telegram/getChatAdministratorsParams))



(s/def :telegram/getChatMembersCount.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/getChatMembersCountParams (s/keys :req-un [:telegram/getChatMembersCount.chat_id]))
(s/fdef api/get-chat-members-count
  :args (s/cat :token string?
               :params :telegram/getChatMembersCountParams))



(s/def :telegram/getChatMember.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/getChatMember.user_id integer?)
(s/def :telegram/getChatMemberParams
  (s/keys :req-un [:telegram/getChatMember.chat_id :telegram/getChatMember.user_id]))
(s/fdef api/get-chat-member
  :args (s/cat :token string?
               :params :telegram/getChatMemberParams))



(s/def :telegram/setChatStickerSet.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/setChatStickerSet.sticker_set_name string?)
(s/def :telegram/setChatStickerSetParams
  (s/keys :req-un [:telegram/setChatStickerSet.chat_id :telegram/setChatStickerSet.sticker_set_name]))
(s/fdef api/set-chat-sticker-set
  :args (s/cat :token string?
               :params :telegram/setChatStickerSetParams))



(s/def :telegram/deleteChatStickerSet.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/deleteChatStickerSetParams (s/keys :req-un [:telegram/deleteChatStickerSet.chat_id]))
(s/fdef api/delete-chat-sticker-set
  :args (s/cat :token string?
               :params :telegram/deleteChatStickerSetParams))



(s/def :telegram/answerCallbackQuery.callback_query_id string?)
(s/def :telegram/answerCallbackQuery.text string?)
(s/def :telegram/answerCallbackQuery.show_alert boolean?)
(s/def :telegram/answerCallbackQuery.url string?)
(s/def :telegram/answerCallbackQuery.cache_time integer?)
(s/def :telegram/answerCallbackQueryParams
  (s/keys
    :req-un [:telegram/answerCallbackQuery.callback_query_id]
    :opt-un [:telegram/answerCallbackQuery.text
             :telegram/answerCallbackQuery.show_alert
             :telegram/answerCallbackQuery.url
             :telegram/answerCallbackQuery.cache_time]))
(s/fdef api/answer-callback-query
  :args (s/cat :token string?
               :params :telegram/answerCallbackQueryParams))



(s/def :telegram/editMessageText.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/editMessageText.message_id integer?)
(s/def :telegram/editMessageText.inline_message_id string?)
(s/def :telegram/editMessageText.text string?)
(s/def :telegram/editMessageText.parse_mode string?)
(s/def :telegram/editMessageText.disable_web_page_preview boolean?)
(s/def :telegram/editMessageText.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/editMessageTextParams
  (s/keys
    :req-un [:telegram/editMessageText.text]
    :opt-un [:telegram/editMessageText.chat_id
             :telegram/editMessageText.message_id
             :telegram/editMessageText.inline_message_id
             :telegram/editMessageText.parse_mode
             :telegram/editMessageText.disable_web_page_preview
             :telegram/editMessageText.reply_markup]))
(s/fdef api/edit-message-text
  :args (s/cat :token string?
               :params :telegram/editMessageTextParams))



(s/def :telegram/editMessageCaption.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/editMessageCaption.message_id integer?)
(s/def :telegram/editMessageCaption.inline_message_id string?)
(s/def :telegram/editMessageCaption.caption string?)
(s/def :telegram/editMessageCaption.parse_mode string?)
(s/def :telegram/editMessageCaption.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/editMessageCaptionParams
  (s/keys
    :opt-un [:telegram/editMessageCaption.chat_id
             :telegram/editMessageCaption.message_id
             :telegram/editMessageCaption.inline_message_id
             :telegram/editMessageCaption.caption
             :telegram/editMessageCaption.parse_mode
             :telegram/editMessageCaption.reply_markup]))
(s/fdef api/edit-message-caption
  :args (s/cat :token string?
               :params :telegram/editMessageCaptionParams))



(s/def :telegram/editMessageMedia.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/editMessageMedia.message_id integer?)
(s/def :telegram/editMessageMedia.inline_message_id string?)
(s/def :telegram/editMessageMedia.media :telegram/InputMedia)
(s/def :telegram/editMessageMedia.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/editMessageMediaParams
  (s/keys
    :req-un [:telegram/editMessageMedia.media]
    :opt-un [:telegram/editMessageMedia.chat_id
             :telegram/editMessageMedia.message_id
             :telegram/editMessageMedia.inline_message_id
             :telegram/editMessageMedia.reply_markup]))
(s/fdef api/edit-message-media
  :args (s/cat :token string?
               :params :telegram/editMessageMediaParams))



(s/def :telegram/editMessageReplyMarkup.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/editMessageReplyMarkup.message_id integer?)
(s/def :telegram/editMessageReplyMarkup.inline_message_id string?)
(s/def :telegram/editMessageReplyMarkup.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/editMessageReplyMarkupParams
  (s/keys
    :opt-un [:telegram/editMessageReplyMarkup.chat_id
             :telegram/editMessageReplyMarkup.message_id
             :telegram/editMessageReplyMarkup.inline_message_id
             :telegram/editMessageReplyMarkup.reply_markup]))
(s/fdef api/edit-message-reply-markup
  :args (s/cat :token string?
               :params :telegram/editMessageReplyMarkupParams))



(s/def :telegram/deleteMessage.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/deleteMessage.message_id integer?)
(s/def :telegram/deleteMessageParams
  (s/keys :req-un [:telegram/deleteMessage.chat_id :telegram/deleteMessage.message_id]))
(s/fdef api/delete-message
  :args (s/cat :token string?
               :params :telegram/deleteMessageParams))



(s/def :telegram/sendSticker.chat_id (s/or :string string? :integer integer?))
(s/def :telegram/sendSticker.sticker (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/sendSticker.disable_notification boolean?)
(s/def :telegram/sendSticker.reply_to_message_id integer?)
(s/def :telegram/sendSticker.reply_markup
  (s/or :InlineKeyboardMarkup :telegram/InlineKeyboardMarkup
        :ReplyKeyboardMarkup :telegram/ReplyKeyboardMarkup
        :ReplyKeyboardRemove :telegram/ReplyKeyboardRemove
        :ForceReply :telegram/ForceReply))
(s/def :telegram/sendStickerParams
  (s/keys
    :req-un [:telegram/sendSticker.chat_id :telegram/sendSticker.sticker]
    :opt-un [:telegram/sendSticker.disable_notification
             :telegram/sendSticker.reply_to_message_id
             :telegram/sendSticker.reply_markup]))
(s/fdef api/send-sticker
  :args (s/cat :token string?
               :params :telegram/sendStickerParams))



(s/def :telegram/getStickerSet.name string?)
(s/def :telegram/getStickerSetParams
  (s/keys :req-un [:telegram/getStickerSet.name]))
(s/fdef api/get-sticker-set
  :args (s/cat :token string?
               :params :telegram/getStickerSetParams))



(s/def :telegram/uploadStickerFile.user_id integer?)
(s/def :telegram/uploadStickerFile.png_sticker :telegram/InputFile)
(s/def :telegram/uploadStickerFileParams
  (s/keys :req-un [:telegram/uploadStickerFile.user_id
                   :telegram/uploadStickerFile.png_sticker]))
(s/fdef api/upload-sticker-file
  :args (s/cat :token string?
               :params :telegram/uploadStickerFileParams))



(s/def :telegram/createNewStickerSet.user_id integer?)
(s/def :telegram/createNewStickerSet.name string?)
(s/def :telegram/createNewStickerSet.title string?)
(s/def :telegram/createNewStickerSet.png_sticker (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/createNewStickerSet.emojis string?)
(s/def :telegram/createNewStickerSet.contains_masks boolean?)
(s/def :telegram/createNewStickerSet.mask_position :telegram/MaskPosition)
(s/def :telegram/createNewStickerSetParams
  (s/keys
    :req-un [:telegram/createNewStickerSet.user_id
             :telegram/createNewStickerSet.name
             :telegram/createNewStickerSet.title
             :telegram/createNewStickerSet.png_sticker
             :telegram/createNewStickerSet.emojis]
    :opt-un [:telegram/createNewStickerSet.contains_masks
             :telegram/createNewStickerSet.mask_position]))
(s/fdef api/create-new-sticker-set
  :args (s/cat :token string?
               :params :telegram/createNewStickerSetParams))



(s/def :telegram/addStickerToSet.user_id integer?)
(s/def :telegram/addStickerToSet.name string?)
(s/def :telegram/addStickerToSet.png_sticker (s/or :string string? :InputFile :telegram/InputFile))
(s/def :telegram/addStickerToSet.emojis string?)
(s/def :telegram/addStickerToSet.mask_position :telegram/MaskPosition)
(s/def :telegram/addStickerToSetParams
  (s/keys
    :req-un [:telegram/addStickerToSet.user_id
             :telegram/addStickerToSet.name
             :telegram/addStickerToSet.png_sticker
             :telegram/addStickerToSet.emojis]
    :opt-un [:telegram/addStickerToSet.mask_position]))
(s/fdef api/add-sticker-to-set
  :args (s/cat :token string?
               :params :telegram/addStickerToSetParams))



(s/def :telegram/setStickerPositionInSet.sticker string?)
(s/def :telegram/setStickerPositionInSet.position integer?)
(s/def :telegram/setStickerPositionInSetParams
  (s/keys :req-un [:telegram/setStickerPositionInSet.sticker
                   :telegram/setStickerPositionInSet.position]))
(s/fdef api/set-sticker-position-in-set
  :args (s/cat :token string?
               :params :telegram/setStickerPositionInSetParams))



(s/def :telegram/deleteStickerFromSet.sticker string?)
(s/def :telegram/deleteStickerFromSetParams
  (s/keys :req-un [:telegram/deleteStickerFromSet.sticker]))
(s/fdef api/delete-sticker-from-set
  :args (s/cat :token string?
               :params :telegram/deleteStickerFromSetParams))



(s/def :telegram/answerInlineQuery.inline_query_id string?)
(s/def :telegram/answerInlineQuery.results (s/coll-of :telegram/InlineQueryResult))
(s/def :telegram/answerInlineQuery.cache_time integer?)
(s/def :telegram/answerInlineQuery.is_personal boolean?)
(s/def :telegram/answerInlineQuery.next_offset string?)
(s/def :telegram/answerInlineQuery.switch_pm_text string?)
(s/def :telegram/answerInlineQuery.switch_pm_parameter string?)
(s/def :telegram/answerInlineQueryParams
  (s/keys
    :req-un [:telegram/answerInlineQuery.inline_query_id
             :telegram/answerInlineQuery.results]
    :opt-un [:telegram/answerInlineQuery.cache_time
             :telegram/answerInlineQuery.is_personal
             :telegram/answerInlineQuery.next_offset
             :telegram/answerInlineQuery.switch_pm_text
             :telegram/answerInlineQuery.switch_pm_parameter]))
(s/fdef api/answer-inline-query
  :args (s/cat :token string?
               :params :telegram/answerInlineQueryParams))



(s/def :telegram/sendInvoice.chat_id integer?)
(s/def :telegram/sendInvoice.title string?)
(s/def :telegram/sendInvoice.description string?)
(s/def :telegram/sendInvoice.payload string?)
(s/def :telegram/sendInvoice.provider_token string?)
(s/def :telegram/sendInvoice.start_parameter string?)
(s/def :telegram/sendInvoice.currency string?)
(s/def :telegram/sendInvoice.prices (s/coll-of :telegram/LabeledPrice))
(s/def :telegram/sendInvoice.provider_data string?)
(s/def :telegram/sendInvoice.photo_url string?)
(s/def :telegram/sendInvoice.photo_size integer?)
(s/def :telegram/sendInvoice.photo_width integer?)
(s/def :telegram/sendInvoice.photo_height integer?)
(s/def :telegram/sendInvoice.need_name boolean?)
(s/def :telegram/sendInvoice.need_phone_number boolean?)
(s/def :telegram/sendInvoice.need_email boolean?)
(s/def :telegram/sendInvoice.need_shipping_address boolean?)
(s/def :telegram/sendInvoice.send_phone_number_to_provider boolean?)
(s/def :telegram/sendInvoice.send_email_to_provider boolean?)
(s/def :telegram/sendInvoice.is_flexible boolean?)
(s/def :telegram/sendInvoice.disable_notification boolean?)
(s/def :telegram/sendInvoice.reply_to_message_id integer?)
(s/def :telegram/sendInvoice.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/sendInvoiceParams
  (s/keys
    :req-un [:telegram/sendInvoice.chat_id
             :telegram/sendInvoice.title
             :telegram/sendInvoice.description
             :telegram/sendInvoice.payload
             :telegram/sendInvoice.provider_token
             :telegram/sendInvoice.start_parameter
             :telegram/sendInvoice.currency
             :telegram/sendInvoice.prices]
    :opt-un [:telegram/sendInvoice.provider_data
             :telegram/sendInvoice.photo_url
             :telegram/sendInvoice.photo_size
             :telegram/sendInvoice.photo_width
             :telegram/sendInvoice.photo_height
             :telegram/sendInvoice.need_name
             :telegram/sendInvoice.need_phone_number
             :telegram/sendInvoice.need_email
             :telegram/sendInvoice.need_shipping_address
             :telegram/sendInvoice.send_phone_number_to_provider
             :telegram/sendInvoice.send_email_to_provider
             :telegram/sendInvoice.is_flexible
             :telegram/sendInvoice.disable_notification
             :telegram/sendInvoice.reply_to_message_id
             :telegram/sendInvoice.reply_markup]))
(s/fdef api/send-invoice
  :args (s/cat :token string?
               :params :telegram/sendInvoiceParams))



(s/def :telegram/answerShippingQuery.shipping_query_id string?)
(s/def :telegram/answerShippingQuery.ok boolean?)
(s/def :telegram/answerShippingQuery.shipping_options (s/coll-of :telegram/ShippingOption))
(s/def :telegram/answerShippingQuery.error_message string?)
(s/def :telegram/answerShippingQueryParams
  (s/keys
    :req-un [:telegram/answerShippingQuery.shipping_query_id
             :telegram/answerShippingQuery.ok]
    :opt-un [:telegram/answerShippingQuery.shipping_options
             :telegram/answerShippingQuery.error_message]))
(s/fdef api/answer-shipping-query
  :args (s/cat :token string?
               :params :telegram/answerShippingQueryParams))



(s/def :telegram/answerPreCheckoutQuery.pre_checkout_query_id string?)
(s/def :telegram/answerPreCheckoutQuery.ok boolean?)
(s/def :telegram/answerPreCheckoutQuery.error_message string?)
(s/def :telegram/answerPreCheckoutQueryParams
  (s/keys
    :req-un [:telegram/answerPreCheckoutQuery.pre_checkout_query_id
             :telegram/answerPreCheckoutQuery.ok]
    :opt-un [:telegram/answerPreCheckoutQuery.error_message]))
(s/fdef api/answer-pre-checkout-query
  :args (s/cat :token string?
               :params :telegram/answerPreCheckoutQueryParams))



(s/def :telegram/setPassportDataErrors.user_id integer?)
(s/def :telegram/setPassportDataErrors.errors (s/coll-of :telegram/PassportElementError))
(s/def :telegram/setPassportDataErrorsParams
  (s/keys :req-un [:telegram/setPassportDataErrors.user_id
                   :telegram/setPassportDataErrors.errors]))
(s/fdef api/set-passport-data-errors
  :args (s/cat :token string?
               :params :telegram/setPassportDataErrorsParams))



(s/def :telegram/sendGame.chat_id integer?)
(s/def :telegram/sendGame.game_short_name string?)
(s/def :telegram/sendGame.disable_notification boolean?)
(s/def :telegram/sendGame.reply_to_message_id integer?)
(s/def :telegram/sendGame.reply_markup :telegram/InlineKeyboardMarkup)
(s/def :telegram/sendGameParams
  (s/keys
    :req-un [:telegram/sendGame.chat_id
             :telegram/sendGame.game_short_name]
    :opt-un [:telegram/sendGame.disable_notification
             :telegram/sendGame.reply_to_message_id
             :telegram/sendGame.reply_markup]))
(s/fdef api/send-game
  :args (s/cat :token string?
               :params :telegram/sendGameParams))



(s/def :telegram/setGameScore.user_id integer?)
(s/def :telegram/setGameScore.score integer?)
(s/def :telegram/setGameScore.force boolean?)
(s/def :telegram/setGameScore.disable_edit_message boolean?)
(s/def :telegram/setGameScore.chat_id integer?)
(s/def :telegram/setGameScore.message_id integer?)
(s/def :telegram/setGameScore.inline_message_id string?)
(s/def :telegram/setGameScoreParams
  (s/keys
    :req-un [:telegram/setGameScore.user_id
             :telegram/setGameScore.score]
    :opt-un [:telegram/setGameScore.force
             :telegram/setGameScore.disable_edit_message
             :telegram/setGameScore.chat_id
             :telegram/setGameScore.message_id
             :telegram/setGameScore.inline_message_id]))
(s/fdef api/set-game-score
  :args (s/cat :token string?
               :params :telegram/setGameScoreParams))



(s/def :telegram/getGameHighScores.user_id integer?)
(s/def :telegram/getGameHighScores.chat_id integer?)
(s/def :telegram/getGameHighScores.message_id integer?)
(s/def :telegram/getGameHighScores.inline_message_id string?)
(s/def :telegram/getGameHighScoresParams
  (s/keys
    :req-un [:telegram/getGameHighScores.user_id]
    :opt-un [:telegram/getGameHighScores.chat_id
             :telegram/getGameHighScores.message_id
             :telegram/getGameHighScores.inline_message_id]))
(s/fdef api/get-game-high-scores
  :args (s/cat :token string?
               :params :telegram/getGameHighScoresParams))







