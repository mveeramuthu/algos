import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        if(cpdomains == null || cpdomains.length <= 0){
            return Collections.emptyList();
        }

        var countMap = new HashMap<String, Integer>();

        for (var cpdomain : cpdomains) {

            var pair = cpdomain.split("\\s+");
            int count = Integer.parseInt(pair[0]);
            var domainFragments = pair[1].split("\\.");
            int domainFragmentsLen = domainFragments.length;

            String subdomain = "";
            for (int i = domainFragmentsLen-1; i >= 0; i--) {
                subdomain = domainFragments[i] + (i < domainFragmentsLen-1 ? "." : "") + subdomain;
                countMap.put(subdomain, countMap.getOrDefault(subdomain, 0) + count);
            }
        }

        var resultList = new ArrayList<String>();
        for (var entry : countMap.entrySet()) {
            resultList.add(entry.getValue() + " " + entry.getKey());
        }

        return resultList;
    }
}
