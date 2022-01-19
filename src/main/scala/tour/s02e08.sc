trait User {
  def username: String
}

trait Tweeter {
  this: User =>  // reassign this
  def tweet(tweetText: String): Unit = println(s"$username: $tweetText")
}

trait PowerUser extends User {
  def username = "abc"
}

class VerifiedTweeter(val username_ : String) extends Tweeter with PowerUser {
  override def username = s"real $username_"
}

val realBeyoncé = new VerifiedTweeter("Beyoncé")
realBeyoncé.tweet("Just spilled my glass of lemonade")
