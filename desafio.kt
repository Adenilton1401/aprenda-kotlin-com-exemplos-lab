// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { 
    BASICO,
    INTERMEDIARIO,
    DIFICIL
    }

class Usuario (val id: Int, val nome: String,)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na Formação $nome")
    }

    fun addConteudoEducacional(nome: String, duracao : Int, nivel: Nivel){
        conteudos.add(ConteudoEducacional(nome, duracao, nivel))
    }
    
    fun listConteudosEducacionais(){
        for (conteudo in conteudos){
            println("Aula: ${conteudo.nome} - Duração: ${conteudo.duracao} min - Nível: ${conteudo.nivel}")
        }
    }
    
    fun listInscritos(){
        for(inscrito in inscritos){
            println("Aluno: ${inscrito.nome}")
        }
        
    }
    
    fun removeInscrito(id: Int){
        if (inscritos.removeIf{it.id == id}){
            println("Usuário removido com sucesso.")
        } else{
            println("Usuário não encontrado.")
        }
    }
}

fun main() {
    val cursoKotlin = Formacao ("Curso Kotlin Basico")
    cursoKotlin.matricular(Usuario(1, "Adenilton"))
    cursoKotlin.matricular(Usuario(2, "Pedro"))
    cursoKotlin.matricular(Usuario(3, "Lucas"))
    cursoKotlin.addConteudoEducacional("Intrudução ao Kotlin", 20, Nivel.BASICO)
    cursoKotlin.addConteudoEducacional("Estruturas de Repetição", 50, Nivel.INTERMEDIARIO)
    cursoKotlin.addConteudoEducacional("Excepiton no Kotlin", 30, Nivel.DIFICIL)
    
    cursoKotlin.listConteudosEducacionais()
    cursoKotlin.listInscritos()
    cursoKotlin.removeInscrito(2)
    cursoKotlin.listInscritos()
    cursoKotlin.removeInscrito(4)
    

}