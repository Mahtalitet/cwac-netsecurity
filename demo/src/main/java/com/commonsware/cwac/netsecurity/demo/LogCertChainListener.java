/***
 Copyright (c) 2016 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.
 */

package com.commonsware.cwac.netsecurity.demo;

import android.util.Log;
import com.commonsware.cwac.netsecurity.CertChainListener;
import java.security.cert.X509Certificate;

public class LogCertChainListener implements CertChainListener {
  @Override
  public void onChain(X509Certificate[] chain, String domain) {
    if (domain==null) {
      Log.d(getClass().getSimpleName(),
        "Certificate chain for request to unknown domain");
    }
    else {
      Log.d(getClass().getSimpleName(),
        "Certificate chain for request to: "+domain);
    }

    for (X509Certificate cert : chain) {
      Log.d(getClass().getSimpleName(),
        "Subject: "+cert.getSubjectX500Principal().getName());
      Log.d(getClass().getSimpleName(),
        "Issuer: "+cert.getIssuerX500Principal().getName());
    }
  }
}
