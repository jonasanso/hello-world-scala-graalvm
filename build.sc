import mill._
import scalalib._
import ammonite.ops._
import ammonite.ops.Shellout
import sys.process._

import mill.util.Ctx

object hello extends ScalaModule with GraalVM {
  def scalaVersion = "2.12.5"
  override def mainClass = Some("Hello")
  def native =  T {
    buildNative(assembly(), "hello")
  }
}

trait GraalVM {
  def buildNative(jar: PathRef, name: String)(implicit ctx: Ctx.Dest): Unit = {
    val jarName = s"$name.jar"
    cp(jar.path, ctx.dest / jarName)
    Shellout.executeStream(ctx.dest, Command(Vector("native-image", "-jar", jarName), Map.empty, Shellout.executeStream)) match{
      case CommandResult(0, s) => s.foreach(_.left.foreach(print))
      case c@CommandResult(e, s) =>
        throw ShelloutException(c)
    }
  }
}