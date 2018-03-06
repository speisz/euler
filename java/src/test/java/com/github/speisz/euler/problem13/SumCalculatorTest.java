package com.github.speisz.euler.problem13;

import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SumCalculatorTest {

    @Test
    public void computesSmallSums() {
        assertThat(SumCalculator.ofSummands(valueOf(1), valueOf(2)).getSum(), is(valueOf(3)));
        assertThat(SumCalculator.ofSummands(valueOf(-1), valueOf(2)).getSum(), is(valueOf(1)));
        assertThat(SumCalculator.ofSummands(valueOf(1), valueOf(-2)).getSum(), is(valueOf(-1)));
        assertThat(SumCalculator.ofSummands(valueOf(-1), valueOf(-2)).getSum(), is(valueOf(-3)));
    }

    @Test
    public void computesFistDigitsOfSums() {
        assertThat(SumCalculator.ofSummands(valueOf(5), valueOf(6)).getFirstDigitsOfSum(1), is(valueOf(1)));
    }

    @Test
    public void computeSumOf50DigitNumbers() {
        assertThat(SumCalculator.ofSummands(
                bigInteger("37107287533902102798797998220837590246510135740250"),
                bigInteger("46376937677490009712648124896970078050417018260538"),
                bigInteger("74324986199524741059474233309513058123726617309629"),
                bigInteger("91942213363574161572522430563301811072406154908250"),
                bigInteger("23067588207539346171171980310421047513778063246676"),
                bigInteger("89261670696623633820136378418383684178734361726757"),
                bigInteger("28112879812849979408065481931592621691275889832738"),
                bigInteger("44274228917432520321923589422876796487670272189318"),
                bigInteger("47451445736001306439091167216856844588711603153276"),
                bigInteger("70386486105843025439939619828917593665686757934951"),
                bigInteger("62176457141856560629502157223196586755079324193331"),
                bigInteger("64906352462741904929101432445813822663347944758178"),
                bigInteger("92575867718337217661963751590579239728245598838407"),
                bigInteger("58203565325359399008402633568948830189458628227828"),
                bigInteger("80181199384826282014278194139940567587151170094390"),
                bigInteger("35398664372827112653829987240784473053190104293586"),
                bigInteger("86515506006295864861532075273371959191420517255829"),
                bigInteger("71693888707715466499115593487603532921714970056938"),
                bigInteger("54370070576826684624621495650076471787294438377604"),
                bigInteger("53282654108756828443191190634694037855217779295145"),
                bigInteger("36123272525000296071075082563815656710885258350721"),
                bigInteger("45876576172410976447339110607218265236877223636045"),
                bigInteger("17423706905851860660448207621209813287860733969412"),
                bigInteger("81142660418086830619328460811191061556940512689692"),
                bigInteger("51934325451728388641918047049293215058642563049483"),
                bigInteger("62467221648435076201727918039944693004732956340691"),
                bigInteger("15732444386908125794514089057706229429197107928209"),
                bigInteger("55037687525678773091862540744969844508330393682126"),
                bigInteger("18336384825330154686196124348767681297534375946515"),
                bigInteger("80386287592878490201521685554828717201219257766954"),
                bigInteger("78182833757993103614740356856449095527097864797581"),
                bigInteger("16726320100436897842553539920931837441497806860984"),
                bigInteger("48403098129077791799088218795327364475675590848030"),
                bigInteger("87086987551392711854517078544161852424320693150332"),
                bigInteger("59959406895756536782107074926966537676326235447210"),
                bigInteger("69793950679652694742597709739166693763042633987085"),
                bigInteger("41052684708299085211399427365734116182760315001271"),
                bigInteger("65378607361501080857009149939512557028198746004375"),
                bigInteger("35829035317434717326932123578154982629742552737307"),
                bigInteger("94953759765105305946966067683156574377167401875275"),
                bigInteger("88902802571733229619176668713819931811048770190271"),
                bigInteger("25267680276078003013678680992525463401061632866526"),
                bigInteger("36270218540497705585629946580636237993140746255962"),
                bigInteger("24074486908231174977792365466257246923322810917141"),
                bigInteger("91430288197103288597806669760892938638285025333403"),
                bigInteger("34413065578016127815921815005561868836468420090470"),
                bigInteger("23053081172816430487623791969842487255036638784583"),
                bigInteger("11487696932154902810424020138335124462181441773470"),
                bigInteger("63783299490636259666498587618221225225512486764533"),
                bigInteger("67720186971698544312419572409913959008952310058822"),
                bigInteger("95548255300263520781532296796249481641953868218774"),
                bigInteger("76085327132285723110424803456124867697064507995236"),
                bigInteger("37774242535411291684276865538926205024910326572967"),
                bigInteger("23701913275725675285653248258265463092207058596522"),
                bigInteger("29798860272258331913126375147341994889534765745501"),
                bigInteger("18495701454879288984856827726077713721403798879715"),
                bigInteger("38298203783031473527721580348144513491373226651381"),
                bigInteger("34829543829199918180278916522431027392251122869539"),
                bigInteger("40957953066405232632538044100059654939159879593635"),
                bigInteger("29746152185502371307642255121183693803580388584903"),
                bigInteger("41698116222072977186158236678424689157993532961922"),
                bigInteger("62467957194401269043877107275048102390895523597457"),
                bigInteger("23189706772547915061505504953922979530901129967519"),
                bigInteger("86188088225875314529584099251203829009407770775672"),
                bigInteger("11306739708304724483816533873502340845647058077308"),
                bigInteger("82959174767140363198008187129011875491310547126581"),
                bigInteger("97623331044818386269515456334926366572897563400500"),
                bigInteger("42846280183517070527831839425882145521227251250327"),
                bigInteger("55121603546981200581762165212827652751691296897789"),
                bigInteger("32238195734329339946437501907836945765883352399886"),
                bigInteger("75506164965184775180738168837861091527357929701337"),
                bigInteger("62177842752192623401942399639168044983993173312731"),
                bigInteger("32924185707147349566916674687634660915035914677504"),
                bigInteger("99518671430235219628894890102423325116913619626622"),
                bigInteger("73267460800591547471830798392868535206946944540724"),
                bigInteger("76841822524674417161514036427982273348055556214818"),
                bigInteger("97142617910342598647204516893989422179826088076852"),
                bigInteger("87783646182799346313767754307809363333018982642090"),
                bigInteger("10848802521674670883215120185883543223812876952786"),
                bigInteger("71329612474782464538636993009049310363619763878039"),
                bigInteger("62184073572399794223406235393808339651327408011116"),
                bigInteger("66627891981488087797941876876144230030984490851411"),
                bigInteger("60661826293682836764744779239180335110989069790714"),
                bigInteger("85786944089552990653640447425576083659976645795096"),
                bigInteger("66024396409905389607120198219976047599490197230297"),
                bigInteger("64913982680032973156037120041377903785566085089252"),
                bigInteger("16730939319872750275468906903707539413042652315011"),
                bigInteger("94809377245048795150954100921645863754710598436791"),
                bigInteger("78639167021187492431995700641917969777599028300699"),
                bigInteger("15368713711936614952811305876380278410754449733078"),
                bigInteger("40789923115535562561142322423255033685442488917353"),
                bigInteger("44889911501440648020369068063960672322193204149535"),
                bigInteger("41503128880339536053299340368006977710650566631954"),
                bigInteger("81234880673210146739058568557934581403627822703280"),
                bigInteger("82616570773948327592232845941706525094512325230608"),
                bigInteger("22918802058777319719839450180888072429661980811197"),
                bigInteger("77158542502016545090413245809786882778948721859617"),
                bigInteger("72107838435069186155435662884062257473692284509516"),
                bigInteger("20849603980134001723930671666823555245252804609722"),
                bigInteger("53503534226472524250874054075591789781264330331690")
        ).getFirstDigitsOfSum(10), is(valueOf(5537376230L)));
    }

    private BigInteger bigInteger(String stringRepresentation) {
        return new BigInteger(stringRepresentation);
    }
}
