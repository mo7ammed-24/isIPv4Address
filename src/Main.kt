fun main() {
    print(isIPv4Address("152.75.77.10"))
}

fun isIPv4Address(inputString: String): Boolean {
    var count=0
    for(i in 0 until inputString.length)
        if(inputString[i]=='.')
            count++
    if(count==3){
        var firstDotIndex=-1
        var secondDotIndex=-1
        var thirdDotIndex=-1
        for(i in 0 until inputString.length){
            if(inputString[i]=='.' && firstDotIndex==-1)
                firstDotIndex=i
            else if(inputString[i]=='.' && secondDotIndex==-1)
                secondDotIndex=i

            else if(inputString[i]=='.' && thirdDotIndex==-1)
                thirdDotIndex=i
            else continue }
        var myIpList=mutableListOf<Long>()
        var part1String=""
        for(i in 0 until firstDotIndex)
            part1String=part1String.plus(inputString[i].toString())

        if(part1String.startsWith('0')&&part1String.length>1)
            return false
        if(isNumber(part1String)&& part1String.toLong()<=255)
            myIpList.add(part1String.toLong())
        var part2String=""
        for(i in firstDotIndex+1 until secondDotIndex)
            part2String=part2String.plus(inputString[i].toString())

        if(part2String.startsWith('0')&&part2String.length>1)
            return false

        if(isNumber(part2String)&& part2String.toLong()<=255)
            myIpList.add(part2String.toLong())
        var part3String=""
        for(i in secondDotIndex+1 until thirdDotIndex)
            part3String=part3String.plus(inputString[i].toString())

        if(part3String.startsWith('0')&&part3String.length>1)
            return false

        if(isNumber(part3String)&& part3String.toLong()<=255)
            myIpList.add(part3String.toLong())
        var part4String=""
        for(i in thirdDotIndex+1 until inputString.length)
            part4String=part4String.plus(inputString[i].toString())

        if(part4String.startsWith('0')&&part4String.length>1)
            return false

        if(isNumber(part4String)&& part4String.toLong()<=255)
            myIpList.add(part4String.toLong())

        if(myIpList.size==4)
            return true
        else
            return false}

    else return false}


fun isNumber(s: String?): Boolean {
    return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
}
