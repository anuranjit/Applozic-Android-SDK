package com.applozic.mobicomkit.uiwidgets;

import android.content.Context;
import android.content.SharedPreferences;

import com.applozic.mobicomkit.api.MobiComKitClientService;
import com.applozic.mobicomkit.api.account.user.MobiComUserPreference;

import java.util.Map;

/**
 * Created by devashish on 8/21/2015.
 */
public class ApplozicSetting {

    private Context context;
    public SharedPreferences sharedPreferences;
    private static final String START_NEW_FLOATING_ACTION_BUTTON_DISPLAY = "SETTING_START_NEW_FLOATING_ACTION_BUTTON_DISPLAY";
    private static final String START_NEW_BUTTON_DISPLAY = "SETTING_START_NEW_BUTTON_DISPLAY";
    private static final String NO_CONVERSATION_LABEL = "SETTING_NO_CONVERSATION_LABEL";
    private static final String CONVERSATION_CONTACT_IMAGE_VISIBILITY = "CONVERSATION_CONTACT_IMAGE_VISIBILITY";
    public static final String CUSTOM_MESSAGE_BACKGROUND_COLOR = "CUSTOM_MESSAGE_BACKGROUND_COLOR";
    private static final String SENT_MESSAGE_BACKGROUND_COLOR = "SENT_MESSAGE_BACKGROUND_COLOR";
    private static final String RECEIVED_MESSAGE_BACKGROUND_COLOR = "RECEIVED_MESSAGE_BACKGROUND_COLOR";
    private static final String ONLINE_STATUS_MASTER_LIST = "ONLINE_STATUS_MASTER_LIST";
    private static final String PRICE_WIDGET = "PRICE_WIDGET";
    private static final String SEND_BUTTON_BACKGROUND_COLOR ="SEND_BUTTON_BACKGROUND_COLOR";
    private static final String START_NEW_GROUP ="START_NEW_GROUP";
    private static final String IMAGE_COMPRESSION ="IMAGE_COMPRESSION";
    private static final String MAX_ATTACHMENT_ALLOWED= "MAX_ATTACHMENT_ALLOWED";
    private static final String LOCATION_SHARE_VIA_MAP = "LOCATION_SHARE_VIA_MAP";
    private static final String MAX_ATTACHMENT_SIZE_ALLOWED= "MAX_ATTACHMENT_SIZE_ALLOWED";
    private static final String INVITE_FRIENDS_IN_PEOPLE_ACTIVITY = "INVITE_FRIENDS_IN_PEOPLE_ACTIVITY";
    private static final String ATTACHMENT_ICONS_BACKGROUND_COLOR = "ATTACHMENT_ICONS_BACKGROUND_COLOR";
    private static final String SENT_CONTACT_MESSAGE_TEXT_COLOR = "SENT_CONTACT_MESSAGE_TEXT_COLOR";
    private static final String RECEIVED_CONTACT_MESSAGE_TEXT_COLOR = "RECEIVED_CONTACT_MESSAGE_TEXT_COLOR";
    private static final String SENT_MESSAGE_TEXT_COLOR = "SENT_MESSAGE_TEXT_COLOR";
    private static final String RECEIVED_MESSAGE_TEXT_COLOR = "RECEIVED_MESSAGE_TEXT_COLOR";
    private static final String TOTAL_ONLINE_USERS = "TOTAL_ONLINE_USERS";
    private static final String SENT_MESSAGE_BORDER_COLOR = "SENT_MESSAGE_BORDER_COLOR";
    private static final String RECEIVED_MESSAGE_BORDER_COLOR = "RECEIVED_MESSAGE_BORDER_COLOR";
    private static final String CHAT_BACKGROUND_COLOR_OR_DRAWABLE= "CHAT_BACKGROUND_COLOR_OR_DRAWABLE";
    private static final String MESSAGE_EDITTEXT_TEXT_COLOR= "MESSAGE_EDITTEXT_TEXT_COLOR";
    private static final String AUDIO_PERMISSON_NOT_FOUND_MSG= "AUDIO_PERMISSON_NOT_FOUND_MSG";
    private static final String REGISTERED_USER_CONTACT_LIST = "REGISTERED_USER_CONTACT_LIST";
    private static final String REGISTERED_USER_CONTACT_LIST_CALL = "REGISTERED_USER_CONTACT_LIST_CALL";
    private static final String CREATE_ANY_CONTACT = "CREATE_ANY_CONTACT";
    private static final String SHOW_ACTION_DIAL_WITH_OUT_CALLING = "SHOW_ACTION_DIAL_WITH_OUT_CALLING";
    private static final String SENT_MESSAGE_LINK_TEXT_COLOR = "SENT_MESSAGE_LINK_TEXT_COLOR";
    private static final String RECEIVED_MESSAGE_LINK_TEXT_COLOR  = "RECEIVED_MESSAGE_LINK_TEXT_COLOR";
    private static final String MESSAGE_EDITTEXT_HINT_TEXT_COLOR= "MESSAGE_EDITTEXT_HINT_TEXT_COLOR";
    private static final String USER_IS_BUSY_MESSAGE = "User is busy";
    private static final String HIDE_GROUP_ADD_MEMBERS_BUTTON = "HIDE_GROUP_ADD_MEMBERS_BUTTON";
    private static final String HIDE_GROUP_NAME_UPDATE_BUTTON= "HIDE_GROUP_NAME_UPDATE_BUTTON";
    private static final String HIDE_GROUP_EXIT_BUTTON= "HIDE_GROUP_EXIT_BUTTON";
    private static final String HIDE_GROUP_REMOVE_MEMBER_OPTION= "HIDE_GROUP_REMOVE_MEMBER_OPTION";
    private static final String EDIT_TEXT_BACKGROUND_COLOR_OR_DRAWABLE= "EDIT_TEXT_BACKGROUND_COLOR_OR_DRAWABLE";
    private static final String EDIT_TEXT_LAYOUT_BACKGROUND_COLOR_OR_DRAWABLE= "EDIT_TEXT_LAYOUT_BACKGROUND_COLOR_OR_DRAWABLE";
    private static final String TYPING_TEXT_COLOR= "TYPING_TEXT_COLOR";

    private static final String ACTIVITY_CALLBACK = "ACTIVITY_CALLBACK_";


    public static ApplozicSetting applozicSetting;

    private ApplozicSetting(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(MobiComKitClientService.getApplicationKey(context), context.MODE_PRIVATE);
    }

    public static ApplozicSetting getInstance(Context context) {
        if (applozicSetting == null) {
            applozicSetting = new ApplozicSetting(context);
        }

        return applozicSetting;
    }

    public enum RequestCode {

        MESSAGE_TAP(Integer.valueOf("1905")), PROFILE_VIEW(Integer.valueOf("1903")), USER_BLOCK(Integer.valueOf("1904"));
        private Integer value;

        RequestCode(Integer c) {
            value = c;
        }

        public Integer getValue() {
            return value;
        }
    }


    public ApplozicSetting setActivityCallbacks(Map<RequestCode, String> activityCallbacks) {
        for (Map.Entry<RequestCode, String> entry : activityCallbacks.entrySet()) {
            sharedPreferences.edit().putString(ACTIVITY_CALLBACK + entry.getKey().getValue(), entry.getValue()).commit();
        }
        return this;
    }

    public String getActivityCallback(RequestCode requestCode) {
        return sharedPreferences.getString(ACTIVITY_CALLBACK + requestCode.getValue(), null);
    }

    public ApplozicSetting setColor(String key, int color) {
        sharedPreferences.edit().putInt(key, color).commit();
        return this;
    }

    public int getColor(String key) {
        return sharedPreferences.getInt(key, R.color.applozic_theme_color_primary);
    }

    public ApplozicSetting setSentMessageBackgroundColor(int color) {
        sharedPreferences.edit().putInt(SENT_MESSAGE_BACKGROUND_COLOR, color).commit();
        return this;
    }

    public ApplozicSetting setReceivedMessageBackgroundColor(int color) {
        sharedPreferences.edit().putInt(RECEIVED_MESSAGE_BACKGROUND_COLOR, color).commit();
        return this;
    }

    public int getSentMessageBackgroundColor() {
        return sharedPreferences.getInt(SENT_MESSAGE_BACKGROUND_COLOR, R.color.applozic_theme_color_primary);
    }

    public int getReceivedMessageBackgroundColor() {
        return sharedPreferences.getInt(RECEIVED_MESSAGE_BACKGROUND_COLOR, R.color.white);
    }

    public ApplozicSetting setSentMessageBorderColor(int color) {
        sharedPreferences.edit().putInt(SENT_MESSAGE_BORDER_COLOR, color).commit();
        return this;
    }

    public ApplozicSetting setReceivedMessageBorderColor(int color) {
        sharedPreferences.edit().putInt(RECEIVED_MESSAGE_BORDER_COLOR, color).commit();
        return this;
    }

    public int getSentMessageBorderColor() {
        return sharedPreferences.getInt(SENT_MESSAGE_BORDER_COLOR, R.color.applozic_theme_color_primary);
    }

    public int getReceivedMessageBorderColor() {
        return sharedPreferences.getInt(RECEIVED_MESSAGE_BORDER_COLOR, R.color.white);
    }

    public ApplozicSetting setAttachmentIconsBackgroundColor(int color) {
        sharedPreferences.edit().putInt(ATTACHMENT_ICONS_BACKGROUND_COLOR, color).commit();
        return this;
    }

    public int getAttachmentIconsBackgroundColor() {
        return sharedPreferences.getInt(ATTACHMENT_ICONS_BACKGROUND_COLOR,R.color.applozic_theme_color_primary);
    }

    public ApplozicSetting setChatBackgroundColorOrDrawableResource(int colorOrDrawable) {
        sharedPreferences.edit().putInt(CHAT_BACKGROUND_COLOR_OR_DRAWABLE, colorOrDrawable).apply();
        return this;
    }

    public int getChatBackgroundColorOrDrawableResource() {
        return sharedPreferences.getInt(CHAT_BACKGROUND_COLOR_OR_DRAWABLE,R.color.conversation_list_background);
    }

    public ApplozicSetting setEditTextBackgroundColorOrDrawableResource(int colorOrDrawable) {
        sharedPreferences.edit().putInt(EDIT_TEXT_BACKGROUND_COLOR_OR_DRAWABLE, colorOrDrawable).apply();
        return this;
    }

    public int getEditTextBackgroundColorOrDrawableResource() {
        return sharedPreferences.getInt(EDIT_TEXT_BACKGROUND_COLOR_OR_DRAWABLE,R.drawable.input);
    }


    public ApplozicSetting setEditTextLayoutBackgroundColorOrDrawableResource(int colorOrDrawable) {
        sharedPreferences.edit().putInt(EDIT_TEXT_LAYOUT_BACKGROUND_COLOR_OR_DRAWABLE, colorOrDrawable).apply();
        return this;
    }

    public int getEditTextLayoutBackgroundColorOrDrawableResource() {
        return sharedPreferences.getInt(EDIT_TEXT_LAYOUT_BACKGROUND_COLOR_OR_DRAWABLE,android.R.color.transparent);
    }


    public ApplozicSetting setTypingTextColor(int color) {
        sharedPreferences.edit().putInt(TYPING_TEXT_COLOR, color).apply();
        return this;
    }

    public int getTypingTextColor() {
        return sharedPreferences.getInt(TYPING_TEXT_COLOR,R.color.black);
    }

    public ApplozicSetting setMessageEditTextTextColor(int textColor) {
        sharedPreferences.edit().putInt(MESSAGE_EDITTEXT_TEXT_COLOR, textColor).apply();
        return this;
    }

    public int getMessageEditTextTextColor() {
        return sharedPreferences.getInt(MESSAGE_EDITTEXT_TEXT_COLOR,R.color.black);
    }

    public ApplozicSetting setMessageEditTextHintColor(int textColor) {
        sharedPreferences.edit().putInt(MESSAGE_EDITTEXT_HINT_TEXT_COLOR, textColor).apply();
        return this;
    }

    public int getMessageEditTextHintColor() {
        return sharedPreferences.getInt(MESSAGE_EDITTEXT_HINT_TEXT_COLOR,R.color.edittext_hint_color);
    }

    public ApplozicSetting setSentContactMessageTextColor(int color) {
        sharedPreferences.edit().putInt(SENT_CONTACT_MESSAGE_TEXT_COLOR, color).commit();
        return this;
    }

    public int getSentContactMessageTextColor() {
        return sharedPreferences.getInt(SENT_CONTACT_MESSAGE_TEXT_COLOR,R.color.white);
    }

    public ApplozicSetting setReceivedContactMessageTextColor(int color) {
        sharedPreferences.edit().putInt(RECEIVED_CONTACT_MESSAGE_TEXT_COLOR, color).commit();
        return this;
    }

    public int getReceivedContactMessageTextColor() {
        return sharedPreferences.getInt(RECEIVED_CONTACT_MESSAGE_TEXT_COLOR,R.color.black);
    }

    public ApplozicSetting setSentMessageTextColor(int color) {
        sharedPreferences.edit().putInt(SENT_MESSAGE_TEXT_COLOR, color).commit();
        return this;
    }

    public int getSentMessageTextColor() {
        return sharedPreferences.getInt(SENT_MESSAGE_TEXT_COLOR,R.color.white);
    }

    public ApplozicSetting setReceivedMessageTextColor(int color) {
        sharedPreferences.edit().putInt(RECEIVED_MESSAGE_TEXT_COLOR, color).commit();
        return this;
    }

    public int getReceivedMessageTextColor() {
        return sharedPreferences.getInt(RECEIVED_MESSAGE_TEXT_COLOR,R.color.black);
    }

    public ApplozicSetting setSentMessageLinkTextColor(int color) {
        sharedPreferences.edit().putInt(SENT_MESSAGE_LINK_TEXT_COLOR, color).apply();
        return this;
    }

    public int getSentMessageLinkTextColor() {
        return sharedPreferences.getInt(SENT_MESSAGE_LINK_TEXT_COLOR,R.color.white);
    }

    public ApplozicSetting setReceivedMessageLinkTextColor(int color) {
        sharedPreferences.edit().putInt(RECEIVED_MESSAGE_LINK_TEXT_COLOR, color).apply();
        return this;
    }

    public int getReceivedMessageLinkTextColor() {
        return sharedPreferences.getInt(RECEIVED_MESSAGE_LINK_TEXT_COLOR,R.color.applozic_green_color);
    }


    public ApplozicSetting showOnlineStatusInMasterList() {
        sharedPreferences.edit().putBoolean(ONLINE_STATUS_MASTER_LIST, true).commit();
        return this;
    }

    public ApplozicSetting hideOnlineStatusInMasterList() {
        sharedPreferences.edit().putBoolean(ONLINE_STATUS_MASTER_LIST, false).commit();
        return this;
    }

    public boolean isOnlineStatusInMasterListVisible() {
        return sharedPreferences.getBoolean(ONLINE_STATUS_MASTER_LIST, false);
    }

    public ApplozicSetting showConversationContactImage() {
        sharedPreferences.edit().putBoolean(CONVERSATION_CONTACT_IMAGE_VISIBILITY, true).commit();
        return this;
    }

    public ApplozicSetting hideConversationContactImage() {
        sharedPreferences.edit().putBoolean(CONVERSATION_CONTACT_IMAGE_VISIBILITY, false).commit();
        return this;
    }

    public boolean isConversationContactImageVisible() {
        return sharedPreferences.getBoolean(CONVERSATION_CONTACT_IMAGE_VISIBILITY, true);
    }

    public ApplozicSetting showStartNewButton() {
        sharedPreferences.edit().putBoolean(START_NEW_BUTTON_DISPLAY, true).commit();
        return this;
    }

    public ApplozicSetting hideStartNewButton() {
        sharedPreferences.edit().putBoolean(START_NEW_BUTTON_DISPLAY, false).commit();
        return this;
    }

    public boolean isStartNewButtonVisible() {
        return sharedPreferences.getBoolean(START_NEW_BUTTON_DISPLAY, false);
    }

    public ApplozicSetting showStartNewFloatingActionButton() {
        sharedPreferences.edit().putBoolean(START_NEW_FLOATING_ACTION_BUTTON_DISPLAY, true).commit();
        return this;
    }

    public ApplozicSetting hideStartNewFloatingActionButton() {
        sharedPreferences.edit().putBoolean(START_NEW_FLOATING_ACTION_BUTTON_DISPLAY, false).commit();
        return this;
    }

    public boolean isStartNewFloatingActionButtonVisible() {
        return sharedPreferences.getBoolean(START_NEW_BUTTON_DISPLAY, false);
    }

    public String getNoConversationLabel() {
        return sharedPreferences.getString(NO_CONVERSATION_LABEL, context.getResources().getString(R.string.no_conversation));
    }

    public ApplozicSetting setNoConversationLabel(String label) {
        sharedPreferences.edit().putString(NO_CONVERSATION_LABEL, label).commit();
        return this;
    }

    public ApplozicSetting showPriceOption() {
        sharedPreferences.edit().putBoolean(PRICE_WIDGET, true).commit();
        return this;
    }

    public ApplozicSetting hidePriceOption() {
        sharedPreferences.edit().putBoolean(PRICE_WIDGET, false).commit();
        return this;
    }

    public boolean isPriceOptionVisible() {
        return sharedPreferences.getBoolean(PRICE_WIDGET, false);
    }

    public ApplozicSetting setSendButtonBackgroundColor(int color) {
        sharedPreferences.edit().putInt(SEND_BUTTON_BACKGROUND_COLOR, color).commit();
        return this;
    }

    public int getSendButtonBackgroundColor() {
        return sharedPreferences.getInt(SEND_BUTTON_BACKGROUND_COLOR, R.color.applozic_theme_color_primary);
    }

    public ApplozicSetting showStartNewGroupButton() {
        sharedPreferences.edit().putBoolean(START_NEW_GROUP, true).commit();
        return this;
    }

    public ApplozicSetting hideStartNewGroupButton() {
        sharedPreferences.edit().putBoolean(START_NEW_GROUP, false).commit();
        return this;
    }

    public boolean isStartNewGroupButtonVisible() {
        return sharedPreferences.getBoolean(START_NEW_GROUP, true);
    }

    public ApplozicSetting showInviteFriendsButton() {
        sharedPreferences.edit().putBoolean(INVITE_FRIENDS_IN_PEOPLE_ACTIVITY, true).commit();
        return this;
    }

    public ApplozicSetting hideInviteFriendsButton() {
        sharedPreferences.edit().putBoolean(INVITE_FRIENDS_IN_PEOPLE_ACTIVITY, false).commit();
        return this;
    }

    public boolean isInviteFriendsButtonVisible() {
        return sharedPreferences.getBoolean(INVITE_FRIENDS_IN_PEOPLE_ACTIVITY, false);
    }


    public ApplozicSetting enableImageCompression() {
        MobiComUserPreference.getInstance(context).setImageCompressionEnabled(true);
        return this;
    }

    public ApplozicSetting disableImageCompression() {
        MobiComUserPreference.getInstance(context).setImageCompressionEnabled(false);
        return this;
    }

    public boolean isImageCompressionEnabled() {
        return MobiComUserPreference.getInstance(context).isImageCompressionEnabled();
    }

    public ApplozicSetting setCompressedImageSizeInMB(int size) {
        MobiComUserPreference.getInstance(context).setCompressedImageSizeInMB(size);
        return this;

    }

    //==== LOCATION SHARING PREFERENCE =====================


    public ApplozicSetting enableLocationSharingViaMap() {
        setLocationSharingViaMap(true);
        return this;
    }

    public ApplozicSetting disableLocationSharingViaMap() {
        setLocationSharingViaMap(false);
        return this;
    }

    public boolean isLocationSharingViaMap() {
       return sharedPreferences.getBoolean(LOCATION_SHARE_VIA_MAP, true);
    }

    public ApplozicSetting setLocationSharingViaMap(boolean value) {
        sharedPreferences.edit().putBoolean(LOCATION_SHARE_VIA_MAP, value).commit();
        return this;
    }


    //===== END ========================================

    public int getCompressedImageSizeInMB() {
        return MobiComUserPreference.getInstance(context).getCompressedImageSizeInMB();
    }

    public ApplozicSetting setMaxAttachmentAllowed(int maxAttachment) {
        sharedPreferences.edit().putInt(MAX_ATTACHMENT_ALLOWED, maxAttachment).commit();
        return this;
    }

    //Default value is 5.
    public int getMaxAttachmentAllowed(){
       return  sharedPreferences.getInt(MAX_ATTACHMENT_ALLOWED, 5);
    }

    public ApplozicSetting setMaxAttachmentSize(int maxAttachmentSize) {
        sharedPreferences.edit().putInt(MAX_ATTACHMENT_SIZE_ALLOWED, maxAttachmentSize).commit();
        return this;
    }

    //Default file size is 10.
    public int getMaxAttachmentSizeAllowed(){
        return  sharedPreferences.getInt(MAX_ATTACHMENT_SIZE_ALLOWED, 10);
    }

    public int getTotalOnlineUser(){
        return  sharedPreferences.getInt(TOTAL_ONLINE_USERS, 0);
    }

    public ApplozicSetting setTotalOnlineUserToFetch(int totalNumber) {
        sharedPreferences.edit().putInt(TOTAL_ONLINE_USERS, totalNumber).apply();
        return this;
    }

    public String getTextForAudioPermissionNotFound() {
        return sharedPreferences.getString(AUDIO_PERMISSON_NOT_FOUND_MSG, null);
    }

    public ApplozicSetting setTextForAudioPermissionNotFound(String messageText) {
        sharedPreferences.edit().putString(AUDIO_PERMISSON_NOT_FOUND_MSG, messageText).commit();
        return this;
    }

    public boolean isHideGroupAddMemberButton() {
        return sharedPreferences.getBoolean(HIDE_GROUP_ADD_MEMBERS_BUTTON, false);
    }

    public ApplozicSetting setHideGroupAddButton(boolean hideGroupAddButton) {
        sharedPreferences.edit().putBoolean(HIDE_GROUP_ADD_MEMBERS_BUTTON, hideGroupAddButton).commit();
        return this;
    }


    public boolean isHideGroupExitMemberButton() {
        return sharedPreferences.getBoolean(HIDE_GROUP_EXIT_BUTTON, false);
    }

    public ApplozicSetting setHideGroupExitButton(boolean hideGroupExitButton) {
        sharedPreferences.edit().putBoolean(HIDE_GROUP_EXIT_BUTTON, hideGroupExitButton).commit();
        return this;
    }


    public boolean isHideGroupNameEditButton() {
        return sharedPreferences.getBoolean(HIDE_GROUP_NAME_UPDATE_BUTTON, false);
    }

    public ApplozicSetting setHideGroupNameEditButton(boolean hideGroupExitButton) {
        sharedPreferences.edit().putBoolean(HIDE_GROUP_NAME_UPDATE_BUTTON, hideGroupExitButton).commit();
        return this;
    }

    public boolean isHideGroupRemoveMemberOption() {
        return sharedPreferences.getBoolean(HIDE_GROUP_REMOVE_MEMBER_OPTION, false);
    }

    public ApplozicSetting setHideGroupRemoveMemberOption(boolean hideRemoveMemberOption) {
        sharedPreferences.edit().putBoolean(HIDE_GROUP_REMOVE_MEMBER_OPTION, hideRemoveMemberOption).commit();
        return this;
    }

    public int getTotalRegisteredUsers(){
        return  sharedPreferences.getInt(REGISTERED_USER_CONTACT_LIST, 100);
    }

    public ApplozicSetting setTotalRegisteredUsersToFetch(int totalNumber) {
        sharedPreferences.edit().putInt(REGISTERED_USER_CONTACT_LIST, totalNumber).apply();
        return this;
    }

    public ApplozicSetting enableRegisteredUsersContactCall(){
        sharedPreferences.edit().putBoolean(REGISTERED_USER_CONTACT_LIST_CALL,true).apply();
        return this;
    }

    public boolean isRegisteredUsersContactCall() {
        return sharedPreferences.getBoolean(REGISTERED_USER_CONTACT_LIST_CALL, false);
    }

    public ApplozicSetting enableCreateAnyContact(){
        sharedPreferences.edit().putBoolean(CREATE_ANY_CONTACT,true).apply();
        return this;
    }

    public boolean isCreateAnyContact() {
        return sharedPreferences.getBoolean(CREATE_ANY_CONTACT, false);
    }

    public ApplozicSetting showActionDialWithoutCalling(){
        sharedPreferences.edit().putBoolean(SHOW_ACTION_DIAL_WITH_OUT_CALLING,true).apply();
        return this;
    }

    public boolean isActionDialWithoutCallingEnabled() {
        return sharedPreferences.getBoolean(SHOW_ACTION_DIAL_WITH_OUT_CALLING, false);
    }
    public void setUserIsBusyMessage(String message){
        sharedPreferences.edit().putString(USER_IS_BUSY_MESSAGE, message).apply();
    }

    public String getUserIsBusyMessage(){
        return sharedPreferences.getString(USER_IS_BUSY_MESSAGE, USER_IS_BUSY_MESSAGE);
    }

    public boolean clearAll() {
        return sharedPreferences.edit().clear().commit();
    }

}