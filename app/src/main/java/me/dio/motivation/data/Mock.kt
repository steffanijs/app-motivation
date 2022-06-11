package me.dio.motivation.data

import me.dio.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int, val language: String)

class Mock {
    private val all = MotivationConstants.FILTER.ALL
    private val happy = MotivationConstants.FILTER.HAPPY
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val langPt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langEn = MotivationConstants.LANGUAGE.ENGLISH
    private val langFr = MotivationConstants.LANGUAGE.FRENCH
    private val langEs = MotivationConstants.LANGUAGE.ESPANOL

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy, langPt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            happy,
            langPt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy, langPt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            happy,
            langPt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, langPt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            happy,
            langPt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, langPt),
        Phrase("Se você acredita, faz toda a diferença.", sunny, langPt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            sunny,
            langPt
        ),
        Phrase("Not knowing it was impossible, he went there and did it.", happy, langEn),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            happy,
            langEn
        ),
        Phrase("When it's darker, we see more stars!", happy, langEn),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            happy,
            langEn
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", happy, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", happy, langEn),
        Phrase("The best way to predict the future is to invent it.", sunny, langEn),
        Phrase("You lose every chance you don't take.", sunny, langEn),
        Phrase("Failure is the spice that flavors success.", sunny, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", sunny, langEn),
        Phrase("If you don't know where you want to go, any way will do.", sunny, langEn),
        Phrase("If you believe, it makes all the difference.", sunny, langEn),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            sunny,
            langEn
        ),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", happy, langFr),
        Phrase(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            happy,
            langFr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", happy, langFr),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            happy,
            langFr
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", happy, langFr),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            happy,
            langFr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", sunny, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", sunny, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", sunny, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", sunny, langFr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            sunny,
            langFr
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", sunny, langFr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            sunny,langFr
        ),
        Phrase ("Sin saber que era imposible, fui allí y lo hice.", happy, langEs),
        Phrase ("¡No estás derrotado cuando pierdes, estás derrotado cuando te rindes!",
             happy, langEs),
        Phrase("¡Cuando oscurece, vemos más estrellas!", happy, langEs),
        Phrase("La locura es hacer lo mismo una y otra vez y esperar un resultado diferente"
            ,happy, langEs ),
        Phrase("No te detengas cuando estés cansado, detente cuando hayas terminado.",
            happy, langEs),
        Phrase("¿Qué puedes hacer ahora que tenga el mayor impacto en tu éxito?",
            happy, langEs),
        Phrase("La mejor manera de predecir el futuro es inventarlo.", sunny, langEs),
        Phrase("Pierdes todas las oportunidades que no tomas.", sunny, langEs),
        Phrase("El fracaso es el condimento que da el sabor del éxito.", sunny, langEs),
        Phrase("¡Mientras no estemos comprometidos, habrá vacilación!", sunny, langEs),
        Phrase("Si no sabes a donde quieres ir, cualquier camino servirá.", sunny,
            langEs),
        Phrase("Si lo crees, hace toda la diferencia.", sunny, langEs),
        Phrase(
    "¡Hay que arriesgarse, porque el mayor peligro es no arriesgar nada!",
        sunny, langEs
        )
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int, language: String): String {

        // Caso a língua do usuário não esteja entre as disponíveis
        var langFilter = language.lowercase()
        if (language !in listOf(langEn, langPt, langFr, langEs)) {
            langFilter = langPt
        }

        val filtered = mListPhrases.filter {
            (it.categoryId == value || value == all) && (it.language == langFilter)
        }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }

}