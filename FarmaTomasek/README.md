# Cvičení 8 - Farma

Bude procvičeno dědění, abstraktní třída a rozhraní. Bude využit polymorfismus 
https://www.algoritmy.net/article/23665/Dedicnost-12 a substituční princip https://cs.wikipedia.org/wiki/Liskovov%C3%A9_princip_zastoupen%C3%AD.

Slovní zadání:

Naprogramujte aplikaci Farma, která umožní spravovat seznam zvířat. Správou se rozumí vkládání a odebírání zvířat ze seznamu. Seznam zvířat musí umět sestavit textovou zprávu se všemi zvířaty, kdy každé zvíře bude na novém řádku. Textová zpráva bude obsahovat na jednotlivých řádcích typ, jméno zvířat a zvuk, který zvíře umí. Zvířata budou tři a to pes, kočka a kůň. 

Implementační požadavky

1. Ve třídě Farma mějte jen metodu main, která si vytvoří seznam zvířat.
2. Referenci na instanci seznamu zvířat uložte do proměnné typu Seznam.
3. Z metody main volejte metody, které jsou deklarovány v interfejsu Seznam, kterými ověříte funkčnost seznamu zvířat.
4. Všechny třídy, které se týkají zvířat, mějte v samostatném balíčku "zvirata".
