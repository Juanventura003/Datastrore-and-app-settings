package edu.farmingdale.datastoredemo.data.local

/*
 * Set data for Android Release Emoji name
 * the list contain distinct sequential Emoji name
 */
object LocalEmojiData {
    val EmojiList = listOf(
       "😀", "😃", "😄", "😁", "😆", "😅", "😂", "🤣", "😊", "😇",
         "🙂", "🙃", "😉", "😌", "😍", "🥰", "😘", "😗", "😙", "😚",
            "😋", "😛", "😝", "😜", "🤪", "🤨", "🧐", "🤓", "😎", "🤩",
            "🥳", "😏", "😒", "😞", "😔", "😟", "😕", "🙁", "☹️", "😣",
            "😖", "😫", "😩", "🥺", "😢", "😭", "😤", "😠", "😡", "🤬",
            "😈", "👿", "💀", "☠️", "💩", "🤡", "👹", "👺", "👻", "👽",
            "👾", "🤖", "😺", "😸", "😹", "😻", "😼", "😽", "🙀", "😿",
            "😾", "🙈", "🙉", "🙊", "💋", "💌", "💘", "💝", "💖", "💗",
            "💓", "💞", "💕", "💟", "❣️", "👍", "👎", "✊", "👊", "✌️"
    )

    // I added these emojies and set them equal to a string
    // Made it so we can map these emojis to the toast that we added


    val EmojiNames = mapOf(
        "😀" to "Big Grin",
        "😃" to "Happy Face",
        "😄" to "Smiling Face",
        "😁" to "Cheesy Smile",
        "😆" to "Laughing Hard",
        "😅" to "Nervous Laugh",
        "😂" to "Tears of Joy",
        "🤣" to "Dying Laughing",
        "😊" to "Blushing",
        "😇" to "Angel Face",
        "🙂" to "Simple Smile",
        "😉" to "Winking",
        "😍" to "Heart Eyes",
        "😘" to "Kissy Face",
        "😋" to "Yummy",
        "😎" to "Cool Dude",
        "😢" to "Sad Face",
        "😭" to "Crying",
        "😠" to "Angry",
        "😡" to "Really Mad",
        "💀" to "Dead",
        "💩" to "Poop",
        "👻" to "Ghost",
        "👽" to "Alien",
        "🤖" to "Robot",
        "😺" to "Happy Cat",
        "🙈" to "Can't Look",
        "💋" to "Kiss",
        "💖" to "Sparkle Heart",
        "👍" to "Thumbs Up"
    )
}
