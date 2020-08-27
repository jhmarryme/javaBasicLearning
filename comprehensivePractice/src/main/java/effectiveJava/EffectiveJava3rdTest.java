package effectiveJava;

import effectiveJava._10_equalswithrules.CaseInsensitiveString;
import effectiveJava._2_builder.NutritionFacts;
import effectiveJava._6_notnecessaryobject.RomanNumerals;
import effectiveJava._3_singleton.SingletonWithEnum;
import org.junit.jupiter.api.Test;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/8/25 17:26
 * @Modified By:
 */
public class EffectiveJava3rdTest {

    @Test
    public void testBuilder_2() {
        NutritionFacts build = NutritionFacts.builder().calories(1).carbohydrate(2).servings(1).fat(1).build();

        System.out.println("build = " + build);
    }

    @Test
    public void testSingleton_3() {
        SingletonWithEnum.INSTANCE.setAge(11);
        SingletonWithEnum.INSTANCE.setName("wjh");
        System.out.println(SingletonWithEnum.INSTANCE.leaveTheBuilding());
    }

    @Test
    public void testNonInstantiable_4() {

    }

    @Test
    public void testNotNecessaryObject_6() {
        System.out.println("RomanNumerals.isRomanNumeral(\"IV\") = " + RomanNumerals.isRomanNumeral("IV"));
        System.out.println("RomanNumerals.isRomanNumeral(\"IV1\") = " + RomanNumerals.isRomanNumeral("IV1"));

        long start = 0l;
        long end = 0l;

        // 进行了自动装箱的运行时间 11431
        start = System.currentTimeMillis();
        RomanNumerals.sumWithAutoBoxing();
        end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));

        // 未进行自动装箱的运行时间 988
        start = System.currentTimeMillis();
        RomanNumerals.sumWithoutAutoBoxing();
        end = System.currentTimeMillis();
        System.out.println("(end - start) = " + (end - start));
    }

    @Test
    public void testEqualsWithRules_10() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "Polish";

        System.out.println("cis.equals(s) = " + cis.equals(s));
        System.out.println("s.equals(cis) = " + s.equals(cis));

    }
}
