object CaesarCipher {
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        val shiftedChar = (char - base + shift + 26) % 26 + base
        shiftedChar.toChar
      } else {
        char
      }
    }
  }

  def decrypt(text: String, shift: Int): String = {
    encrypt(text, -shift)
  }

  def main(args: Array[String]): Unit = {
    println("Enter the text : ");
    val message = scala.io.StdIn.readLine();
    println("Enter the shift value");
    val shiftValue = scala.io.StdIn.readInt();

    // Encrypt the message
    val encryptedMessage = encrypt(message, shiftValue)
    println("Encrypted: " + encryptedMessage)

    // Decrypt the encrypted message
    val decryptedMessage = decrypt(encryptedMessage, shiftValue)
    println("Decrypted: " + decryptedMessage)
  }
}

